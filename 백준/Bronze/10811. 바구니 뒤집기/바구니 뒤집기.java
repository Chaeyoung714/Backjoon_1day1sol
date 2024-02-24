import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N, M;
		N = s.nextInt();
		M = s.nextInt();
		int i, j;
		int tmp;
		int[] baskets = new int[N+1];
		
		for (int k=1; k<=N; k++) {
			baskets[k] = k;
		}
		
		for (int l=0; l<M; l++) {
			i = s.nextInt();
			j = s.nextInt();
			while(i<j) {
				tmp = baskets[i];
				baskets[i] = baskets[j];
				baskets[j] = tmp;
					
				i += 1;
				j -= 1;
			}
		}
		for (int b : baskets) {
			if (b==0) continue;
			System.out.printf("%d ", b);
		}
	}

}
