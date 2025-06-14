package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4963 {
    public static boolean [][] visited;
    public static int n, m;
    public static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    public static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void dfs(int y, int x) {
        visited[y][x] = true;
        for(int i=0; i<8; i++){
            int ny = y+dx[i];
            int nx = x+dy[i];
            if(ny >=0 && nx >=0 && ny <n && nx < m && !visited[ny][nx]){
                visited[ny][nx] = true;
                dfs(ny,nx);
            }
        }
    }
    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int curY = arr[0];
            int curX = arr[1];
            for(int i=0; i<8; i++){
                int ny = curY+dy[i];
                int nx = curX+dx[i];
                if(ny >= 0 && nx >= 0 && ny <n && nx < m && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = " ";
        /*
        while(true){
            String line = br.readLine();
            if(line.equals("0 0")) break; // 종료 조건
         */
        while(!(line = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(line);
            m = Integer.parseInt(st.nextToken()); // 가로
            n = Integer.parseInt(st.nextToken()); // 세로
            int count =0;

            visited = new boolean[n][m];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++){
                    int token = Integer.parseInt(st.nextToken());
                    if(token == 0){
                        visited[i][j] = true;
                    }
                }
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(!visited[i][j]){
                        dfs(i,j);
                        count++;
                        /*
                        bfs로 풀었을 경우
                        bfs(i, j);
                        count++
                         */
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
