package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    이분 그래프 문제

 */
public class BOJ1707 {
    public static boolean dfs(int node, int color, ArrayList<ArrayList<Integer>> graph, int[] check){
        check[node] = color;
        for(int next : graph.get(node)){
            if(check[next] ==0){
                // 자식노드와 연결된 그 다음 노드까지 확인함
                if(!dfs(next, -color, graph, check)) return false;
            }
            // 다음게 또 같은 색깔이면 false
            else if(check[next] == color){
                return false;
            }
        }
        // 안되는 조건들을 걸러주고 조건에 안걸리면 true반환하도록 만듬
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            for(int j=0; j<=node; j++) {
                graph.add(new ArrayList<>());
            }
            for(int j=0; j<edge; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            int[] check = new int[node+1];
            boolean isBipartite = true;
            for(int j=1; j<=node; j++){
                if(check[j] == 0){
                    if(!dfs(j,1, graph, check)) {
                        isBipartite = false;
                        break;
                    }
                }
            }
            System.out.println(isBipartite ? "YES" : "NO");
        }

    }
}
