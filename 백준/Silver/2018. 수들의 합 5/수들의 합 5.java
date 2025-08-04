import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int start = 1;  // 시작 포인터
        int end = 1;    // 종료 포인터
        int sum = 1;    // 연속된 자연수의 합
        int count = 1;  // 연속된 자연수의 합이 N과 같은 경우의 수

        while(end != N) {
            if(sum < N) {
                end++;
                sum += end;
            } else if(sum > N) {
                sum -= start;
                start ++;
            } else  { // sum == N
                count++;
                end++;
                sum += end;
            }
        }

        System.out.println(count);
    }
}