package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468 {
    public static int N;
    public static int[][] map;
    public static boolean [][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        while(!queue.isEmpty()) {
            int [] current = queue.poll();
            int curX = current[1];
            int curY = current[0];
            for(int i=0; i<4; i++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];
                if(nX >=0 && nY >=0 && nX < N && nY < N && !visited[nY][nX]) {
                    queue.offer(new int[]{nY, nX});
                    visited[nY][nX] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int maxHeight = 0;

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int height = Integer.parseInt(st.nextToken());
                map[i][j] = height;
                maxHeight = Math.max(maxHeight, height);
            }
        }
        int maxCount =0;
        for(int i= maxHeight; i>=0; i--){
            visited = new boolean[N][N];
            int count =0;
            for(int j=0; i<N; j++){
                for(int k=0; k<N; k++){
                    if(map[j][k] <=i){
                        visited[k][i] = true;
                    }
                }
            }
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(!visited[j][k]){
                        bfs(j,k);
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        System.out.println(maxCount);
    }
}
