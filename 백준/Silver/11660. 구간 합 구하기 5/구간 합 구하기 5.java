import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * sol1: O(n^3) -> 시간초과 sol2: 구간합 -> DP 사용하여 값 누적
     */

    static int[][] table;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        table = new int[N + 1][N + 1];
        DP = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        fillDP(N);

        int[] results = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            results[i] = calculateSum(x1, y1, x2, y2);
        }

        for (int result : results) {
            System.out.println(result);
        }

        br.close();
    }

    private static void fillDP(int N) {
        // 누적합 배열 만들기
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == 1 && j == 1) {
                    DP[i][j] = table[i][j];
                    continue;
                }
                if (i == 1) {
                    DP[i][j] = DP[i][j - 1] + table[i][j];
                    continue;
                }
                if (j == 1) {
                    DP[i][j] = DP[i - 1][j] + table[i][j];
                    continue;
                }
                DP[i][j] = DP[i - 1][j] + DP[i][j - 1] - DP[i - 1][j - 1] + table[i][j];
            }
        }
    }

    private static int calculateSum(int x1, int y1, int x2, int y2) {
        return DP[x2][y2] - (DP[x2][y1 - 1] + DP[x1 - 1][y2] - DP[x1 - 1][y1 - 1]);
    }
}