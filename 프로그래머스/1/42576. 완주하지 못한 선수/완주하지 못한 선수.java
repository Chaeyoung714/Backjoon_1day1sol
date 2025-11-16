/*
완주하지 못한 한 명이 누군지 파악한다.
동명이인이 있을 수 있다. -> contains = true지만 개수가 안맞는 케이스도 있을 것.

가장 단순한 작업 : 모든 선수에 대해 뺀다 -> 시간초과 나겠지
*/

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> completions = new HashMap<>();
        for (String com : completion) {
            completions.put(com, completions.getOrDefault(com, 0) + 1);
        }
        
        for (String p : participant) {
            if (completions.getOrDefault(p, 0) > 0) {
                completions.put(p, completions.get(p) - 1);
            } else {
                answer = p;
                break;
            }
        }
       	 
        return answer;
    }
}