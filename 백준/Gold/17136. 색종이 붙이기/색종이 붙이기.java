import java.io.*;
import java.util.*;

public class Main {

	static int[][] map = new int[10][10];
	static int[] paper = { 0, 5, 5, 5, 5, 5 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static void dfs(int idx, int cnt) {
		if (idx == 100) {
			ans = Math.min(cnt, ans);
			return;
		}
        
		if(ans <= cnt)
			return;

		int x = idx / 10;
		int y = idx % 10;
       
		if (map[x][y] == 1) {
			for (int i = 5; i > 0; i--) {
            	//색종이가 남아있고 && 색종이 부분이 다 1인경우
				if (paper[i]>0 && check(x,y, i)) {
					paper[i] -= 1;
					fill(x,y,i,0);
					dfs(idx + 1, cnt + 1);
					fill(x,y,i,1);
					paper[i] += 1;
				}
			}
		} else
			dfs(idx + 1, cnt);

	}
	static void fill(int x,int y,int paperSize,int num) {
		
		for(int i=x;i<x+paperSize;i++) {
			for(int j=y;j<y+paperSize;j++) {
				map[i][j]=num;
			}
		}
		
	}
	static boolean check(int x, int y,int paperSize) {

		if(x+paperSize>10 || y+paperSize>10) 
			return false;
		
		for(int i=x;i<x+paperSize;i++) {
			for(int j=y;j<y+paperSize;j++) {
				if(map[i][j]!=1)
					return false;
			}
		}
		return true;
	}
}