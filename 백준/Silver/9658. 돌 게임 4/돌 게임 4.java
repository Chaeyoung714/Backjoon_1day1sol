import java.io.*;
import java.util.*;

public class Main {

	static int[] dp;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[1001];
		
		Arrays.fill(dp, -1);
		
		if(solve(n) ==0) {;
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}
	}
	
	static int solve(int num) {
		if(num <= 0) return 0;
		if(dp[num]!=-1) return dp[num];
		
		int win = solve(num-1) + solve(num-3) + solve(num-4);
		if(win >0) {
			return dp[num] = 0;
		}else {
			return dp[num] = 1;
		}
	}
}