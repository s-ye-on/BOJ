package boj.boj18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18352 {
    // 다익스트라로 풀려했는데, 가중치가 다 같으므로 bfs로 푸는게 더 효율적
    public static int nodeCount;
    public static int edgeCount;
    public static int distance;
    public static int startNode;
    public static ArrayList<ArrayList<Integer>> graph;
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        int[] distances = new int [nodeCount+1];
        Arrays.fill(distances, -1);
        distances[start] =0;
        queue.offer(start);
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : graph.get(current)){
                if(distances[next] == -1){
                    distances[next] = distances[current]+1;
                    queue.offer(next);
                }
            }
        }
        boolean judge = false;
        for(int i=1; i<=nodeCount; i++){
            if(distances[i] == distance){
                judge = true;
                System.out.println(i);
            }
        }
        if(!judge){
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(nodeCount+1);
        for(int i=0; i<=nodeCount; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
        }
        // 간선의 길이가 다 1이기에 목표 길이에 도달하려면 몇 개의 노드를 통과하는지만 보면 됨
        bfs(startNode);
    }
}
