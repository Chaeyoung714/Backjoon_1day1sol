/*
1~n번 노드 중 가장 멀리 떨어진 노드의 갯수 = 최단경로로 이동했을때 간선의 수가 가장 많은 노드
가장 멀리 떨어진 노드의 수를 계산한다.
양방향 간선이다.

그래프는 어떤 자료구조로 탐색하는 게 제일 좋을까? 링크드리스트? 해시맵? 2차원배열?

방법 1. 1에서 모든 점으로의 거리를 구한다. (dfs로..) bfs면 끝을 알수가 없다. 
방법 2. 가 있나? 그냥 건너가는 수밖에
시간 생각하면 해시 쓰는게 제일 좋을듯?
*/

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer>[] arr = new ArrayList[n + 1]; //배열 하나당 해당 점이 어디로 갈 수 있는지 저장
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
        }
        
        int[] dists = bfs(arr);
        
        int[] maxSorted = Arrays.stream(dists).boxed().sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue).toArray();
        
        int maxDist = maxSorted[0];
        int maxCount = 0;
        
        for (int dist : maxSorted) {
            if (dist == maxDist) {
                maxCount++;
            } else {
                break;
            }
        }
        
        answer = maxCount;
        
        return answer;
    }
    
    private int[] bfs(List<Integer>[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dists = new int[arr.length];
        
        dists[1] = 1;
        queue.offer(1); //현재 위치, 이동한 거리 (1부터 시작)
        
        while (!queue.isEmpty()) {
            int from = queue.poll();
            int dist = dists[from];
            
            List<Integer> tos = arr[from];
            for (int to : tos) { //배열일 땐 for int to = 2: ... 로 해야 했음
                if (dists[to] > 0) {
                    continue;
                }
                
                dists[to] = dist + 1; 
                queue.offer(to);
            }
        }
        
        return dists;
    }
}