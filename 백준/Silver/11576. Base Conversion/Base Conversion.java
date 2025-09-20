import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<String> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; i++) {
			stack.push(st.nextToken());
		}
		
		int sum = 0;
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(stack.pop());
			for(int j = 0; j < i; j++) {
				num *= a;
			}
			sum += num;
		}
		
		while(sum > 0) {
			stack.push(String.valueOf(sum%b));
			sum /= b;
		}
		
		while(!stack.isEmpty()) bw.write(stack.pop() + " ");
		
		bw.flush();
		bw.close();
		br.close();
	}
}