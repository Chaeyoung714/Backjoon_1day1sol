import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());

        long tail = 0;
        long head = n;
        long mid = 0;
        long ans = 0;

        while(tail <= head) {
            mid = (tail + head) / 2;
            if(Math.pow(mid, 2) >= n) {
                head = mid - 1;
                ans = mid;
            } else {
                tail = mid + 1;
            }
        }
        System.out.println(ans);
    }
}