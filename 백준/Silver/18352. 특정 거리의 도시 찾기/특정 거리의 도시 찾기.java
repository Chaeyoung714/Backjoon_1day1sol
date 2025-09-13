import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] list; // 인접 리스트
    static int distanceArr[]; // 거리를 저장하는 배열

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드 수
        int m = Integer.parseInt(st.nextToken()); // 엣지 수
        int k = Integer.parseInt(st.nextToken()); // 원하는 거리 수
        int x = Integer.parseInt(st.nextToken()); // 출발 노드

        list = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; ++i) list[i] = new ArrayList<>();

        distanceArr = new int[n + 1];
        Arrays.fill(distanceArr, -1); // 거리를 -1로 초기화

        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to); // from에서 to로 가는 경로 추가
        }

        bfs(x); // BFS 수행


        // 거리가 k인 도시 출력
        boolean found = false;
        for (int i = 1; i < n + 1; ++i)
        {
            if (distanceArr[i] == k)
            {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) System.out.println(-1);

    }

    static void bfs(int startCity)
    {
        Queue<Integer> que = new LinkedList<>();
        distanceArr[startCity] = 0; // 시작 도시는 거리가 0
        que.add(startCity); // 큐에 시작 도시 추가
        while (!que.isEmpty()) // 큐가 비어있지 않다면
        {
            int currentCity = que.poll();
            for (int nextCity : list[currentCity]) // 인접 리스트에서 다음 도시를 가져옴
            {
                if (distanceArr[nextCity] == -1) // 거리가 정해지지 않았다면
                {
                    distanceArr[nextCity] = distanceArr[currentCity] + 1; // 다음 도시의 거리는 현재 도시의 거리 +1
                    que.offer(nextCity);
                }
            }
        }
    }
}