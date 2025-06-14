package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    public static int bfs(int start, int target){
        int[] move = {-1, 1, 2};
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100_001];
        queue.offer(new int[] {start, 0});
        visited[start] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];
            if(position == target){
                return time;
            }
            for(int i=0; i<move.length; i++){
                int nextPosition = (move[i]==2) ? position *2 : position + move[i];

                if(nextPosition >= 0 && nextPosition <= 100_000 && !visited[nextPosition]){
                    queue.offer(new int[] {nextPosition, time+1});
                    visited[nextPosition] = true;
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = bfs(N, K);
        System.out.println(result);
    }
}
