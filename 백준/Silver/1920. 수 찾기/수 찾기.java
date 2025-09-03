import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
100,000,000번, N <= 100,000
O(N^2)는 불가능
O(nlogn) = 100,000 * 3.3 * 5 =1,600,000 -> 가능
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> notSortedA = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            notSortedA.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> A = notSortedA.stream().sorted().collect(Collectors.toList());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            sb.append(find(target, A) + "\n");
        }

        System.out.println(sb);
    }

    private static int find(int target, List<Integer> arr) {
        int size = arr.size();
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            if (arr.get(0) == target) {
                return 1;
            }
            return 0;
        }

        int midIndex = (size - 1) / 2;
        int mid = arr.get(midIndex);

        if (mid > target) {
            return find(target, arr.subList(0, midIndex));
        }
        if (mid < target) {
            return find(target, arr.subList(midIndex + 1, size));
        }
        return 1;
    }
}
