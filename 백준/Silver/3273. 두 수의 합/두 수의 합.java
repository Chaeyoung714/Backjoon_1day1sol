import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,x;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);//정렬
		int s=0 , e=n-1, ans=0;//start, end, 정답
		while(s<e) {
			int sum = arr[s]+arr[e];
			if(sum==x) {
				ans++;
				s++;
				continue;
			}
			else if(sum<x) s++;
			else e--;
		}
		
		System.out.println(ans);
	}
}
