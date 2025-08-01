import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] notesByHeight;
    static List<Integer> line = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        notesByHeight = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            notesByHeight[i] = Integer.parseInt(st.nextToken());
        }

        for (int height = n; height > 0; height--) {
            int leftTallerCount = notesByHeight[height];
            line.add(leftTallerCount, height);
        }

        for (int person : line) {
            System.out.printf("%d ", person);
        }
    }
}