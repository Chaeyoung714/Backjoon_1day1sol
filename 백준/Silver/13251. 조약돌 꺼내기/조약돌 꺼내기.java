import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] colors = new int[m];
        int n = 0;
        for (int i = 0; i < m; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
            n += colors[i];
        }

        int k = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else if (j == 1) {
                    dp[i][j] = i;
                } else if (i >= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }

        long total = dp[n][k];

        // 색상 별 확률
        double ans = 0.0;
        for (int c : colors) {
            if (c < k) continue;
            // 비복원 추출의 연속 확률 곱
            double p = 1.0;
            for (int t = 0; t < k; t++) {
                p *= (double)(c - t) / (double)(n - t);
            }
            ans += p;
        }
        System.out.println(ans);
    }
}
