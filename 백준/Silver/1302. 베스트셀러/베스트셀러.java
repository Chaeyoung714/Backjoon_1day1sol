import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max=0;
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            String str=br.readLine();
            map.put(str,map.getOrDefault(str,0)+1);
            max = Math.max(max,map.get(str));
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue()==max) {
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
