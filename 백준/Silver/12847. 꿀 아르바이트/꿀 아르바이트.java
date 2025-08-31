
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = M;
        long answer = 0;
        for(int i=start; i<end; i++) {
            answer+=arr[i];
        }

        long max = answer;
        while (end<N) {
            max = max - arr[start] + arr[end];
            answer = Math.max(answer, max);
            start++;
            end++;
        }
        System.out.println(answer);
    }
}