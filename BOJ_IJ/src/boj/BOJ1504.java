package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class City implements Comparable<City>{
    int to;
    int cost;
    public City(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
    @Override
    public int compareTo(City other){
        return this.cost - other.cost; // 오름차순
    }
}
public class BOJ1504 {
    public static List<City>[] graph;
    public static PriorityQueue<City> pq = new PriorityQueue<City>();
    public static int[] dijkstra(int start, List<City>[] graph, int N) {
        // List<City>[] -> 배열인데 배열의 각 칸에 리스트가 들어있는 자료구조
        // 배열 + 리스트 조합
        // 노드 번호를 인덱스로 하고, 해당 인덱스의 리스트에는 그 노드와 연결된 다른 노드 정보가 들어가있는 구조
        // 그래프 포현 시 -인접행렬 : 2차원 배열로 연결 여부/ 비용 표시, - 인접 리스트 : 각 노드마다 연결된 노드 리스트로 관리
        // 행렬 : 숫자나 값을 표 형태 (2차원 배열)로 정리해 둔 것
        PriorityQueue<City> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new City(start, 0));

        while(!pq.isEmpty()) {
            City current = pq.poll();
            int now = current.to;
            if(dist[now] < current.cost) continue;
            for(City next : graph[now]){
                int newCost = dist[now] + next.cost;
                if(newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new City(next.to, newCost));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        graph = new ArrayList[nodeCount+1];
        for (int i = 0; i <= nodeCount; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=1; i<=edgeCount; i++ ) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new City(to, cost));
            graph[to].add(new City(from, cost)); // 양방향인 경우라
        }
        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 문제에서 반드시 v1과 v2를 거쳐가야한다는 조건이 주어짐 (두개의 노드를 꼭 거치라는 조건)
        // 반드시 1->v1->v2->N 또는 1->v2->v1->N 이 경우임
        int[] fromStart = dijkstra(1, graph, nodeCount);
        int[] fromV1 = dijkstra(v1, graph, nodeCount);
        int[] fromV2 = dijkstra(v2, graph, nodeCount);

        long answer = Math.min(
                (long)fromStart[v1] + fromV1[v2] + fromV2[nodeCount],
                (long)fromStart[v2] + fromV2[v1] + fromV1[nodeCount]
        );
        System.out.println(answer >= Integer.MAX_VALUE ? -1 : answer);
    }
}
