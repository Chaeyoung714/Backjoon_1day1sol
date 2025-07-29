import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] s1 = br.readLine().split(" ");
        
        int N = Integer.parseInt(s1[0]);
        int M = Integer.parseInt(s1[1]);
    
        int[] sum = new int[N+1];
        
        String[] s2 = br.readLine().split(" ");
        sum[0] = 0;
        for(int i = 1; i <= N; i ++) {
            sum[i] = sum[i-1] + Integer.parseInt(s2[i-1]);
        }
        
        for(int i = 0; i < M; i++) {
            String[] s3 = br.readLine().split(" ");
            int start = Integer.parseInt(s3[0]);
            int end = Integer.parseInt(s3[1]);
            System.out.println(sum[end] - sum[start-1]);
        }
    }
}