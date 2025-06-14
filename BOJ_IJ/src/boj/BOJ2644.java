package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2644 {
    public static int n;
    public static ArrayList<ArrayList<Integer>> family = new ArrayList<>();
    public static int[] visited;
    public static void dfs(int x){
        for(int i =0; i< family.get(x).size(); i++){
            int current = family.get(x).get(i);
            if(visited[current] == 0){
                visited[current] = visited[x] +1;
                dfs(current);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 사람 수
        visited = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int person1 = Integer.parseInt(st.nextToken()); // 사람1
        int person2 = Integer.parseInt(st.nextToken()); // 사람2

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<n+1; i++) {
            family.add(new ArrayList<>());
        }
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            family.get(a).add(b);
            family.get(b).add(a);
        }
        dfs(person1);
        int result = visited[person2];
        System.out.println(result == 0 ? -1 : result);
    }
}
