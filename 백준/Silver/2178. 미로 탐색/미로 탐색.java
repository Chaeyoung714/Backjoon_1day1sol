import java.io.*;
import java.util.*;

public class Main {

    static char[][] miro;
    static int[][] dist;
    static Queue<Pair> queue = new LinkedList<>();

    static int maxCount = 0;
    static int endX;
    static int endY;

    static int[] dX = new int[]{0, 0, 1, -1};
    static int[] dY = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        miro = new char[n][m];
        dist = new int[n][m];
        endX = n - 1;
        endY = m - 1;
        for (int x = 0; x < n; x++) {
            String line = br.readLine();
            for (int y = 0; y < m; y++) {
                miro[x][y] = line.charAt(y);
                dist[x][y] = -1;
            }
        }

        queue.offer(new Pair(0, 0));
        dist[0][0] = 0;
        bfsMiro();

        System.out.println(dist[endX][endY] + 1);
    }

    private static void bfsMiro() {
        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = p.x + dX[i];
                int newY = p.y + dY[i];

                if (newX < 0 || newX > endX || newY < 0 || newY > endY) { //주의
                    continue;
                }
                if (miro[newX][newY] == '0' || dist[newX][newY] != -1) {
                    continue;
                }

                /**
                 * 목적지에 도착하는 순간 최단경로임 -> 바로 out
                 */
                if (newX == endX && newY == endY) {
                    dist[newX][newY] = dist[p.x][p.y] + 1;
                    return;
                }

                queue.offer(new Pair(newX, newY));
                /**
                 * 현재 점의 거리는 부모 점의 거리 + 1 == 부모 점의 레벨(or차수) + 1이다.
                 */
                dist[newX][newY] = dist[p.x][p.y] + 1;
            }
        }
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
