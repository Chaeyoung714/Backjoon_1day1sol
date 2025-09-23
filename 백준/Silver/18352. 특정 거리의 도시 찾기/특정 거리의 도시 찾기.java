
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
        /*
    1~N번 도시와 M개의 단방향 도로, 모든 거리는 1
    x -> 모든 도시로 가는 방법들 중 최단거리 == k인 모든 도시들의 번호 출력
    1->2 : 1
    1->3 : 1
    1->4 : 2
    하나도 없으면 -1 출력

    모든 도시에 대해 bfs가 맞는 것 같음 -> depth = k가 될때까지, 그렇게 k에 도착하면 됨??
    이때, 이미 그전에 도착한 도시는 최단 거리가 아니므로 visited 처리한다.

    그래프의 경우 1->N가지로 뻗어나갈 수 있음. 어떤 자료구조로 저장하는 게 좋을까?
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cityCount = Integer.parseInt(st.nextToken());
        int roadCount = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        int[] distances = new int[cityCount + 1];
        List<Integer>[] roads = new List[cityCount + 1];

        for (int i = 1; i <= cityCount; i++) {
            roads[i] = new ArrayList<>();
            distances[i] = -1;
        }

        for (int i = 0; i < roadCount; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            roads[from].add(to);
        }

        Queue<Integer> queue = new LinkedList<>();
        distances[start] = 0; //시작도시는 거리가 0!!
        queue.add(start);
        while (!queue.isEmpty()) {
            int from = queue.poll();

//            if (distances[from] != -1) { // 시작 노드도 포함되므로 안됨
//                continue;
//            }

            List<Integer> nexts = roads[from];

            for (int next : nexts) {
                if (distances[next] != -1) {
                    continue;
                }
                queue.offer(next);
                distances[next] = distances[from] + 1;
            }
        }

        // dist == k면 나온다
        boolean isEmpty = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= cityCount; i++) {
            if (distances[i] == k) {
                isEmpty = false;
                sb.append(i + "\n");
            }
        }

        if (isEmpty) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb);
    }
}
