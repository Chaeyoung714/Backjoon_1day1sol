/*
던전마다 선이 있음 -> 그 이상이어야 함
최소 필요 피로도 = 던전 탐험 시작 시 가지고 있어야 하는 최소 피로도 
소모 피로도 = 탐험을 마쳤을 때 소모됨 -> 마지막에 (-)
최소 필요 피로도 >= 소모 피로도

최대한 많이 탐험! = 최대한 작게 소모하면서 탐험한다.
최대한 ~~ == dfs 아닌가? 

무조건 작은 소모부터 하면 -> 2개밖에 못탐험한다. 
즉 일정한 규칙은 없기 때문에 DFS로 해야 한다.

1. 가능한 경로를 모두 해본다. 이왕이면 최소 필요 피로도가 낮은 것부터 한다.
2. dfs로 들어간다.
*/

import java.util.*;
import java.io.*;

class Solution {
    static int currMaxCount = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        int maxCount = 0;
        int[] visited = new int[dungeons.length];
        
        answer = dfs(k, visited, dungeons);
        
        return answer;
    }
    
    // 역할 : current 위치에서 끝까지 dfs한 뒤에 나온 최대 던전 수를 반환한다.
    // 이를 호출한 위치 (이전 위치)에서는 여기에 +1을 하면 된다.
    private int dfs(int restTired, int[] visited, int[][] dungeons) {
        int maxCount = 0; //이전 상태에 영향을 받지 않는다. -> 현재 기준에서 몇개만큼 더하는게 제일 이득인지만 계산한다.
        //System.out.println(count + ", " + current + ", " + restTired);
        
        for (int i = 0; i < visited.length; i++) {
            int[] dungeon = dungeons[i];
        	int minTired = dungeon[0];
        	int usedTired = dungeon[1];
            
            if (visited[i] == 0 && restTired >= minTired) {
                visited[i] = 1;
                maxCount = Math.max(dfs(restTired - usedTired, visited, dungeons) + 1, maxCount);
                
                visited[i] = 0;
        	}
        }
        
        return maxCount;
    }
}