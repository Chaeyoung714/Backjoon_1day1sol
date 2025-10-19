import java.io.*;
import java.util.*;

class Main{
	static int[][] map;
	static int[][] answer;
	static int n;
	
    public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	n = Integer.parseInt(br.readLine());
    	map = new int[n][n];
        for(int i = 0 ; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j <n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        // 재귀
        recursion();
        
    }
    // n 값이 1이 될 때 까지 recursion으로 만든다.
    private static void recursion() {
    	// n == 1일 때 값을 출력하고 종료
    	if(n == 1) {
    		System.out.println(answer[0][0]);
    		return;
    	}
    	// n / 2 크기의 새로운 배열
    	answer = new int[n/2][n/2];
    	
    	// answer 배열에 풀링을 적용함
    	recursionMake(0,0,n);
    	// 기존 배열에 n / 2 크기 배열을 넣어준 뒤 n / 2로 만든다.
    	map = answer;
    	n /= 2;
    	// 현재 실행중인 메서드를 재귀 호출한다.
    	recursion();
    }
	
    // 현재 배열을 범위로 나누어준다.
    private static void recursionMake(int x,int y, int len) {
    	// 변이 2일 때 두번째로 큰 크기를 찾아서 배열에 넣어준다.
    	if(len == 2) {
    		searchSecondMax(x,y);
    		return;
    	}
    	len /= 2;
    	// 각 범위별로 재귀 호출
    	recursionMake(x,y,len);
    	recursionMake(x+len,y,len);
    	recursionMake(x,y+len,len);
    	recursionMake(x+len,y+len,len);
    }
    
    // 두번째로 큰 값을 찾아준다.
    private static void searchSecondMax(int x,int y) {
    	// 4개의 값을 배열로 만들어준 뒤 정렬 후 2번째로 큰 수를 찾아서 answer배열에 넣어준다.
    	int[] nums = new int[] {map[x][y], map[x][y+1],map[x+1][y], map[x+1][y+1]};
    	Arrays.sort(nums);
    	answer[x / 2][y/2] = nums[2];
    }
}