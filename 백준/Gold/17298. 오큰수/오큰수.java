import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        int[] ans = new int[n];
        int[] stack = new int[n]; // 인덱스 저장용
        int top = -1;

        // 오른쪽으로 진행하며 "자기보다 큰 수를 아직 못 찾은 인덱스"를 스택에 유지
        for (int i = 0; i < n; i++) {
            while (top >= 0 && a[stack[top]] < a[i]) {
                ans[stack[top--]] = a[i];
            }
            stack[++top] = i;
        }
        while (top >= 0) ans[stack[top--]] = -1;

        StringBuilder sb = new StringBuilder(n * 3);
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}