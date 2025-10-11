import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		int num = in.nextInt();
		int count = 0;
 
		while (num >= 5) { // 5로 나누면서 누적합을 실행해줘야한다.5이상인 이유는 5이하에서는 0이기때문
			count += num / 5;// 5로 나눠질때까지 넣어준다 5의 개수 도출을 위함
			num /= 5;
		}
		System.out.println(count);
	}
 
}
