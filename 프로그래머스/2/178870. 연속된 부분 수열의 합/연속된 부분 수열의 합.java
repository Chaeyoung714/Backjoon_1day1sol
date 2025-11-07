/*
합이 맞는 것 중 길이가 짧고 -> 시작인덱스가 작을수록 좋음
길이를 고정한채 길이 1, 시작인덱스 0부터 오른쪽으로 이동 -> 없으면 길이 2, 시작인덱스 0으로 반복
연속적으로 하나씩 이동 -> 투포인터를 쓰면 구간의 합을 매번 구하지 않고 더하고 빼서 구할 수 있따.
*/

import java.util.*;

class Solution {
    
    static PriorityQueue<int[]> queue;
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        queue = new PriorityQueue<>((a, b) -> {
            // 1순위 : 길이 오름차순
            if (a[0] != b[0]) return a[0] - b[0];
            // 2순위 : start 오름차순
            return a[1] - b[1];
        });
        
        int start = 0; // 헷갈림
        int end = start; //포함
        int sum = sequence[start];
        
        search(start, end, sum, sequence, k);
        
        int[] result = queue.poll();
        answer = new int[]{result[1], result[2]};
        
        return answer;
    }
    
    private void search(int start, int end, int sum, int[] sequence, int k) {
        while (start <= end && end < sequence.length && start < sequence.length) {
            if (sum == k) {
                queue.offer(new int[]{end - start + 1, start, end});
                
                if (end == sequence.length - 1) {
                    break;
                }
                
                // 더 이어갈 수 있으면
                sum += sequence[++end];
                sum -= sequence[start++];
                continue; //ㅜㅜ
            }
            
            if (sum > k) {
                sum -= sequence[start++];
                continue;
            }
            
            if (sum < k) {
                if (end == sequence.length - 1) {
                    break;
                }
                sum += sequence[++end];
            }
        }
    }
}