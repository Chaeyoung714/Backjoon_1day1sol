
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /**
     * sol2 : 다익스트라
     * dp + 우선순위 queue
     */
    static List<Node>[] list; //list[i]에서 갈 수 있는 도시 목록
    static int[] dp; //출발지에서 dp[i]까지 가는 최소 경로
    static boolean[] check;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        dp = new int[n+1];
        check = new boolean[n+1];

        for(int i=1; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to,cost));
        }

        st = new StringTokenizer(br.readLine());
        int start= Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dp[destination]);
    }

    private static void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>(); //우선순위 큐 사용
        Arrays.fill(dp, Integer.MAX_VALUE);

        queue.add(new Node(start, 0));
        dp[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int to = node.to;

            if (check[to]) continue; //방문한 곳은 다시 방문하지 않음

            check[node.to] = true;
            for (Node next : list[to]) {
                if(dp[next.to] >= dp[to] + next.cost) {
                    dp[next.to] = dp[to] + next.cost;
                    queue.add(new Node(next.to, dp[next.to]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
