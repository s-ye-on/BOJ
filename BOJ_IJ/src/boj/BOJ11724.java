package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
    public static int N,M;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : graph.get(cur)){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int count =0;
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
