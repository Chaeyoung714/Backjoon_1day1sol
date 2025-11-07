/*
적절히 더하거나 빼서 타겟 넘버를 만든다.
정수 간 순서를 바꾸지 않고, 오호지 부호만 바꿀 수 있다.
방법의 수를 구한다.

지금까지 계산한 값이 target보다 크면 -> 무조건 빼도 될까? ㄴㄴ
결국 이것도 모든 경우의 수를 봐야할 것 같은데..
마지막 숫자같은 경우는 ㄱㅊ을듯 

dfs의 역할 = 현재까지 만들어진 수를 바탕으로 나올 수 있는 경우의 수 중 target을 만들 수 있는 경우의 수를 구한다.
너무 구체적인 건 고려하지 말고 일단 완전탐색? 처럼 해보자.
*/

import java.util.*;

class Solution {
    static List<int[]> result = new ArrayList<>();
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(numbers, target, 0);
        answer = result.size();
        
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int current) {
        if (current >= numbers.length) {
            int sum = Arrays.stream(numbers).sum();
            if (sum == target) {
            	result.add(numbers);
           	}
            return;
        }
        
        int currentNum = numbers[current];
        dfs(numbers, target, current + 1);
        
        numbers[current] = -currentNum;
        dfs(numbers, target, current + 1);
        numbers[current] = currentNum; //원복
    }
}