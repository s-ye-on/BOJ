package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2606 {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean [] virus;
    public static void dfs(int x){
        virus[x]=true;
        for(int i=0; i<graph.get(x).size(); i++){
            int y = graph.get(x).get(i);
            if(!virus[y]){
                dfs(y);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int virusCount =0;
        int computerCount = Integer.parseInt(br.readLine());
        int connection = Integer.parseInt(br.readLine());

        virus = new boolean[computerCount+1];
        for(int i=0; i<computerCount+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<connection; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        dfs(1);
        for(int i=0; i<computerCount+1; i++){
            if(virus[i]){
                virusCount++;
            }
        }
        System.out.println(virusCount-1);
    }
}