import java.util.*;
import java.io.*;

public class Main {

    static int[] visited;
    static int[] parents;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 일단은 양방향으로 정해야 할 것 같은데
        tree = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 2; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        int start = 1;
        parents = new int[n + 1];
        visited = new int[n + 1];

        dfs(1, -1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parents[i] + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int current, int parent) {
        if (visited[current] == 1) {
            return;
        }
        visited[current] = 1;
        parents[current] = parent;

        List<Integer> nexts = tree[current];

        if (nexts.isEmpty()) {
            return;
        }

        for (int next : nexts) {
            dfs(next, current);
        }
    }
}
