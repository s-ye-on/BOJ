package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    다익스트라 알고리즘
    최단 거리 문제라 bfs로 풀면 되지 않을까 생각했지만
    이 문제는 가중치가 있는 그래프임(이동하는데 드는 비용이 다 같지 않음)
    각 노드까지의 최소 거리를 갱신하면서 우선 순위큐를 사용
    -> 가장 비용이 적게 드는 경로부터 탐색

    PriorityQueue<Integer> pq =
	new PriorityQueue<>(); // 정순

    PriorityQueue<Integer> pq =
	new PriorityQueue<>(Collections.reverseOrder()); // 역순

    PriorityQueue<Task> pq =
	new PriorityQueue<>(Comparator.comparingInt(Task::getProcess)); // 객체이용
 */
class Bus implements Comparable<Bus> {
    int destination;
    int cost;

    Bus(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }
    @Override
    public int compareTo(Bus o) {
        return this.cost - o.cost;
    }
}
public class BOJ1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        ArrayList<ArrayList<Bus>> graph = new ArrayList<>();
        //인접 리스트. 도시 번호마다 이동 가능한 버스들의 리스트를 따로 관리
        // 각 도시마다 이동할 수 있는 노선 모음
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 도시 수
        int M = Integer.parseInt(br.readLine()); // 버스 수
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발 도시
            int b = Integer.parseInt(st.nextToken()); // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 버스 비용
            graph.get(a).add(new Bus(b, c));
        }
        st = new StringTokenizer(br.readLine());
        int departure = Integer.parseInt(st.nextToken());
        int arrival = Integer.parseInt(st.nextToken());
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // 출발 도시부터 각 도시까지 최소 비용 저장
        // 처음은 무한대로 초기화, 출발 도시는 0으로 세팅
        distance[departure] = 0;
        pq.add(new Bus(departure, 0));
        while(!pq.isEmpty()){
            Bus current = pq.poll();

            //이미 더 짧은 경로로 방문했다면 넘어가기
            if(distance[current.destination] < current.cost) continue;
            // 연결된 버스들 체크
            // 지금은 모든 버스를 pq에 넣어놨으니, 인접 리스트로 연결 정보를 따로 관리해야함
            for(Bus next : graph.get(current.destination)){
                int newCost = distance[current.destination] + next.cost;

                if(distance[next.destination] > newCost){
                    distance[next.destination] = newCost;
                    pq.add(new Bus(next.destination, newCost));
                }
            }
        }
        System.out.println(distance[arrival]);
    }
}
