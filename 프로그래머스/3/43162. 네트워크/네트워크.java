// 이 문제는 연결그룹의 개수! 문제임.
// dfs -> 연결될때까지 쭉 돈다.
// 링크드 리스트로 정리해놔야 할까? -> ㄴㄴ 이미 된거지 뭐/
// dfs 역할 : 현재 시적점 기준으로 모든 연결된 요소에 visited=1을 찍고온다.

import java.util.*;

class Solution {
    
    static int total = 0;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int[] visited = new int[n];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                total ++;
                dfs(visited, computers, n, i);
            }
        }
        
        answer = total;
        return answer;
    }
    
    private void dfs(int[] visited, int[][] computers, int n, int current) {
        visited[current] = 1;
        
        for (int to = 0; to < n; to++) {
            if (to == current) {
                continue;
            }
            
            if (computers[current][to] == 1 && visited[to] == 0) {
                dfs(visited, computers, n, to);
            }
        }
    }
}