import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        int [] day = new int[n];
        int [] money = new int[n];
 
        StringTokenizer st ;
        int a, b;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
 
            day[i] = a;
            money[i] = b;
        }// for
 
        int [] dp = new int[n+1];
 
        for (int i = 0; i < n; i++) {
            // 날짜가 초과되지 않으면서 해당 날짜에 번돈을 계산
            if (i + day[i] <= n){
                dp[ i + day[i] ] = Math.max( dp[i + day[i]], dp[i] + money[i] );
            } //if
 
            dp[i + 1] = Math.max( dp[i+1], dp[i] );
 
        } // for
 
        System.out.println(dp[n]);
 
    }
}