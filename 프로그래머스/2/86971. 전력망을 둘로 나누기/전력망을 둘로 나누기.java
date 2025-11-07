/*
하나의 트리 중 한 전선을 끊어서 네트워크를 2개로 만든다.
이때 두 전력망이 가지는 송전탑의 수를 최대한 비슷하게 맞춘다.
최대한 비슷할 때, 두 전력망이 가진 송전탑 개수의 차이

자식의 개수는 1개일수도, 여러개일수도

규칙이 보이는가? -> 음...
어느것을 끊어도 끊기긴 하는가? -> 완전 순환을 이루는 거면 안 끊기긴 한다. 흠.. => "트리" 형태라는건, 끊긴다는 의미 아닐까? => ㅇㅇ맞음!

sol1
각각의 wire을 끊은 후 연결덩어리 개수를 구한다.
연결덩어리를 매번 구해야 할까? 

sol2) 균형 트리 생각하기
가장 거리가 먼 것 사이의 연결고리를 끊으면 된다 -> 트리니까 차수가 있고, 차수가 길어지게 하는 꼬리를 끊어냄.
-> 가장 큰 차이가 나는 두 점 사이에서 끊는다.
이유 : 가장 길다는 건 많은 송전탑을 지니고 있다는거
근데 연관은 있는 것 같은데.. 확신이없슨 ㅠ 결국 트리 높이가 비슷해지는거니까, 옆으로 많은 것까진 커버못함
*/

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        int minAbs = Integer.MAX_VALUE;
        
        List<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }
       
        
        for (int[] wire : wires) {
            tree[wire[0]].remove(tree[wire[0]].indexOf(wire[1]));
            tree[wire[1]].remove(tree[wire[1]].indexOf(wire[0]));
            
            int result = calculate(tree, n);
            minAbs = Math.min(result, minAbs);
            
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }
        
        answer = minAbs;
        
        return answer;
    }
    
    // 역할 : 해당 트리의 연결 그룹 차이를 구한다.
    private int calculate(List<Integer>[] tree, int n) {
        int firstCount = dfs(1, tree, n, new int[n + 1]);
        int secondCount = n - firstCount;
        
        //System.out.println("first : " + firstCount + ", second : " + secondCount);

        return Math.abs(firstCount - secondCount);
    }
    
    // 현재 위치 기준 tree 안에서 연결되어있는 송전탑 개수
    public int dfs(int current, List<Integer>[] tree, int n, int[] visited) {
        List<Integer> tos = tree[current];
        visited[current] = 1; //위치좀..
        
        int count = 1; //현재 기준
        
        for (int to : tos) {
            if (visited[to] == 1) continue;
            
            count += dfs(to, tree, n, visited);
        }
        
        return count; //마지막에 도달했을 때
    }
}