package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Road implements Comparable<Road> {
    int destination;
    int time;
    public Road(int destination, int time){
        this.destination = destination;
        this.time = time;
    }
    @Override
    public int compareTo(Road o) {
        return this.time - o.time;
    }
}
public class BOJ1238 {
    public static int N;
    public static int M;
    public static int X;
    public static ArrayList<ArrayList<Road>> roads = new ArrayList<>();
    public static int[] dijkstra(int start){
        PriorityQueue<Road> pq = new PriorityQueue<>();
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new Road(start, 0));
        while(!pq.isEmpty()){
            Road road = pq.poll();
            if(distance[road.destination] < road.time) continue;
            for(Road next : roads.get(road.destination)){
                int newTime = distance[road.destination] + next.time;
                if(distance[next.destination] > newTime){
                    distance[next.destination] = newTime;
                    pq.add(new Road(next.destination, newTime));
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 단방향 도로 수
        X = Integer.parseInt(st.nextToken()); // 목적지 마을
        int[] durationTime = new int[N+1];
        for(int i=0; i<=N; i++){
            roads.add(new ArrayList<>());
        }
        for(int i=0; i<M; i ++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()); //도로 시작점
            int b = Integer.parseInt(st.nextToken()); //도로 끝점
            int c = Integer.parseInt(st.nextToken()); //소요 시간
            roads.get(a).add(new Road(b, c));
        }
        int[] fromX = dijkstra(X);
        int maxTime =0;
        for(int i=1; i<=N; i++){
            int[] toX = dijkstra(i);
            int totalTime = toX[X] + fromX[i]; // 왕복 시간
            maxTime = Math.max(maxTime, totalTime);
        }
        System.out.println(maxTime);
    }
}
