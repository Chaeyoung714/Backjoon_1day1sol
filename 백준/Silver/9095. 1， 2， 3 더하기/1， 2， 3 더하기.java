import java.io.*;
 
public class Main {
 
    public static int n, t;
    public static int[] dp;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        t = Integer.parseInt(br.readLine());
        int[] count = new int[t];
        dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
 
        for (int k = 4; k <= 11; k++) {
            dp[k] = dp[k - 1] + dp[k - 2] + dp[k - 3];
 
        }
 
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
 
            count[i] = dp[n];
 
        }
        for (int s : count) {
            System.out.println(s);
        }
 
    }
 
}
