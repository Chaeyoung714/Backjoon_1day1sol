import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Map<String, Integer> nameCountMap = new HashMap<>();
		List<String> names = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            nameCountMap.put(name, 0);
        }
        
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (nameCountMap.containsKey(name)) {
            	names.add(name);
            }
        }
        
        Collections.sort(names);
        System.out.println(names.size());
        for(String s : names) {
        	System.out.println(s);
        }
    }
}
