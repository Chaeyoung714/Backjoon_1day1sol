import java.util.*;
import java.io.*;

/**
 * 100,000,000번, N <= 1,000
 * O(n^2)까지 가능~! -> 어떤 정렬이라도 사용 가능
 */
public class Main {
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] times = new int[n];
        String[] timeInputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(timeInputs[i]);
        }

        for (int i = 1; i < n; i++) {
            int current = i;
            int target = i - 1;
            while (target >= 0) {
                if (times[target] <= times[current]) {
                    current--;
                    target--;
                    break;
                }

                int tmp = times[target];
                times[target] = times[current];
                times[current] = tmp;

                current--;
                target--;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += times[i] * (n - i);
        }

        System.out.println(sum);
    }
}