import java.util.*;
 
public class Main {    
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        dfs(0, "", n);
        System.out.println(sb.toString());
    }    
    
    public static void dfs(int idx, String num, int n) {
        if(idx == n) {
            sb.append(num + "\n");
            return;
        }
        
        for(int i = 1; i <= 9; i++) {
            if(isPrime(Integer.valueOf(num + i))) dfs(idx + 1, num + i, n);
        }
    }
    
    public static boolean isPrime(int num) {
        if(num == 1) return false;
 
        int sqrt = (int) Math.sqrt(num);
        for(int i = 2; i <= sqrt; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
