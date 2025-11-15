// 한 자릿수 종이조각을 이어서 만들 수 있는 소수의 개수
// 길이 1 이상 7 이하.
// 각 숫자는 0~9
// 0으로 시작하는 건 고려하지 않는다.
// 소수 = 1과 자기자신 외 나누어떨어지는 수가 없는 수
// 일부만 사용해도 됨

import java.util.*;
import java.io.*;

class Solution {
    
    static List<Integer> primes = new ArrayList<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        int[] numberArr = Arrays.stream(numbers.split(""))
            .mapToInt(num -> Integer.parseInt(num))
            .toArray();
        
        dfs(numberArr, 0);
        
        answer = Long.valueOf(primes.stream().distinct().count()).intValue();
        
        return answer;
    }
    
    private void dfs(int[] numbers, int current) {
        
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number == 0 && current == 0) {
                continue;
            }
            if (number == -1) { //visited
                continue;
            }
            
            int newNumber = current * 10 + number;
            if (newNumber != 1 && isPrime(newNumber)) {
                // System.out.println("found : " + newNumber);
                primes.add(newNumber);
            }
            
            numbers[i] = -1;
            dfs(numbers, newNumber);
            numbers[i] = number;
        }
    }
    
    private boolean isPrime (int number) {
        for (int idx = 2; idx <= number / 2; idx++) {
            if (number % idx == 0) {
                return false;
            }
        }
        return true;
    }
}