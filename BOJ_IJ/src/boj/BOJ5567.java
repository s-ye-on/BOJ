package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5567 {
    public static ArrayList<ArrayList<Integer>> relations = new ArrayList<>();
    public static boolean[] visited;
    public static int bfs(int start){
        int count =0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int node = current[0];
            int depth = current[1];
            if(depth >= 2) continue;
            for(int next : relations.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(new int[]{next, depth+1});
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        for(int i=0; i<N+1; i++){
            relations.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relations.get(a).add(b);
            relations.get(b).add(a);
        }
        int result = bfs(1);
        System.out.println(result);
    }
}
