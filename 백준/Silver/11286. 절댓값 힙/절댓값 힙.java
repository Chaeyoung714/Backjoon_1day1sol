import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            long aa = Math.abs((long) a);
            long bb = Math.abs((long) b);
            if (aa != bb) return aa < bb ? -1 : 1;
            return Integer.compare(a, b); // 절댓값 같으면 작은 수(음수 우선)
        });

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                out.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
            } else {
                pq.offer(x);
            }
        }
        System.out.print(out);
    }
}