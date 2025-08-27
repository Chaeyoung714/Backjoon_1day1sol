import java.io.*;
import java.util.*;

public class Main{
    static int N,M,arr[];
    static boolean visit[];
    static StringBuilder sb;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
      
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[M];
            visit = new boolean[N];
            
            back(0);
            System.out.println(sb);
        
    }
    public static void back(int depth){
        
        if(depth==M){
            for(int i:arr){
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }
        
        for(int i = 0; i<N; i++){
            if(!visit[i]){
                visit[i]=true;
                arr[depth]=i+1;
                back(depth+1);
                visit[i]=false;
            }
        }
    }                                        
}