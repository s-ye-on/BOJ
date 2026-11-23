package boj.boj1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node{
    public int y, x;
    public int cost;
    public Node(int y, int x, int cost) {
        this.y = y;
        this.x = x;
        this.cost = cost;
    }
}
public class BOJ1216_Dijkstra {
    /*
        bfs와 달리 거리 대신 "벽 부순 횟수" 를 기준으로 우선순위 큐를 써서 다익스트라

     */
    public static int M, N;
    public static int[][] map;
    public static int[][] distance;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.cost - b.cost);
        // 코스트 오름차순
        distance[0][0] = 0;
        pq.add(new Node(0, 0, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();

            //만약 현재 꺼낸 값보다 이미 작은 값으로 방문한 경우 continue
            if(distance[current.y][current.x] < current.cost) continue;

            for(int i=0; i<4; i++) {
                int newY = current.y + dy[i];
                int newX = current.x + dx[i];

                if(newY < 0 || newX < 0 || newY >= N || newX >= M) continue;

                int nextCost = current.cost + map[newY][newX]; //벽인 경우 +1
                if(distance[newY][newX] > nextCost) {
                    distance[newY][newX] = nextCost;
                    pq.add(new Node(newY, newX, nextCost));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        map = new int[N][M];
        distance = new int[N][M];

        for(int i=0; i<N; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        dijkstra();
        System.out.println(distance[N-1][M-1]);
    }
}
