import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] numbers = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(numbers);

        int count = 0;
        for (int i = 0; i < n; i++) {
            /**
             * count, start, end가 매번 초기화??
             */
            int start = 0;
            int end = n - 1;
            long target = numbers[i];

            while (true) {
                if (start >= end) {
                    break;
                }

                long currentSum = numbers[start] + numbers[end];
                if (currentSum == target) {
                    if (start != i && end != i) {
                        count++;
                        break;
                    }
                    if (start == i) {
                        start++;
                    }
                    if (end == i) {
                        end--;
                    }
                    continue;
                }
                if (currentSum < target) { // start++ 또는 gap++
                    // ex. 1 -> 2 -> 3 -> 4 -> 6 -> 9
                    // start = 2, gap = 4, num = 9
                    // 일단 두 수의 합은 직전 수보다 같거나 크다는 걸 알고 있음
                    start++;
                    continue;
                }
                end--;
            }
        }

        System.out.println(count);
    }
}
