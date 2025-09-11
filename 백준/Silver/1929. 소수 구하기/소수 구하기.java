import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] deleted = new int[n + 1];
        int[] numbers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numbers[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if (deleted[i] == 1) {
                continue;
            }

            int target = 2 * i;
            while (target <= n) {
                deleted[target] = 1;
                target += i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (i == 1) {
                continue;
            }
            if (deleted[i] == 0) {
                sb.append(i + "\n");
            }
        }

        System.out.println(sb);
    }
}
