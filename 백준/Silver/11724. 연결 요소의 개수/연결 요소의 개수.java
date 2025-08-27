import java.io.*;
import java.util.*;

/**
 * 300,000,000, M <= 500,000
 * O(n^2) -> 안됨
 * O(nlogn) = 500,000 * 3.3 * 6 ~= 10,000,000 -> 될 듯
 */
public class Main {

    static int[] visited;
    static int n;
    static int m;
    static int[][] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점 개수
        m = Integer.parseInt(st.nextToken()); // 간선 개수

        lines = new int[n + 1][n + 1]; // 간선 대신 2차원 배열로!
        visited = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            lines[from][to] = 1;
            lines[to][from] = 1;
        }

        int result = 0;
        for (int edge = 1; edge <= n; edge++) {
            if (visited[edge] == 0) {
                dfs(edge);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int from) {
        visited[from] = 1;

        for (int to = 1; to <= n; to++) {
            if (visited[to] == 0 && lines[from][to] == 1) {
                dfs(to);
            }
        }
    }
}
