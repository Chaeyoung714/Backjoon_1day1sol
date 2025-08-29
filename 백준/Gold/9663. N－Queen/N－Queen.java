import java.io.*;

public class Main {

	static int n;
	static int[] map;
	static int count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<n+1; i++) {
			map = new int[n+1];			
			map[1] = i; // (1,i)에 queen
			dfs(2);
		}
		
		System.out.println(count);
	}
	
	
	
	static void dfs(int depth) {
		
		if(depth > n) {
			count++;
		}
		else {
			for(int i=1; i<n+1; i++) {
				map[depth] = i; // (depth,i)에 queen 
				if(check(depth)) {
					dfs(depth+1);
				}
			}
		}
	}
	
	static boolean check(int depth) {
		
		for(int i=1; i<depth; i++) {
			// 열이 같으면 false
			if(map[i] == map[depth]) return false;

			if(Math.abs(i-depth) == Math.abs(map[i]-map[depth])) return false;
			
		}
		return true;
	}
}