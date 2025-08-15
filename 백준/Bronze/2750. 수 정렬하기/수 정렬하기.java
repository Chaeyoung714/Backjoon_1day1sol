import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 100,000,000번, N <= 1,000
 * O(n^2)까지 가능
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            numbers.add(num);
        }

        List<Integer> sorted = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        for (int num : sorted) {
            System.out.println(num);
        }
    }
}
