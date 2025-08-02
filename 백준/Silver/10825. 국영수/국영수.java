import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][4];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
            arr[i][3] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                if (Integer.parseInt(s1[1]) == Integer.parseInt(s2[1])) {
                    if (Integer.parseInt(s1[2]) == Integer.parseInt(s2[2])) {
                        if (Integer.parseInt(s1[3]) == Integer.parseInt(s2[3])) {

                            // 국영수 모두 같을 때 -> 사전순
                            return s1[0].compareTo(s2[0]);
                        }

                        // 국영 같을 때 -> 수학 내림차순
                        return Integer.compare(Integer.parseInt(s2[3]), Integer.parseInt(s1[3]));

                    }
                    // 국어 같을 때 -> 영어 오름차순
                    return Integer.compare(Integer.parseInt(s1[2]), Integer.parseInt(s2[2]));
                }
                // 국어 내림차순
                return Integer.compare(Integer.parseInt(s2[1]), Integer.parseInt(s1[1]));
            }
        });
        for(int i = 0; i < N; i++){
            System.out.println(arr[i][0]);
        }
    }
}