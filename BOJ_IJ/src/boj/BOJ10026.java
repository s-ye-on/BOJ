package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
    완전 탐색을 해야해서 dfs로만 풀어야된다고 생각했다
    이 문제는 한 영역을 모두 방문처리하는게 중요하다
    -> 방문 처리만 잘 하면 dfs던 bfs던 답은 잘 나온다
 */
public class BOJ10026 {
    public static int N;
    public static char[][] picture;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    // 인접한 좌표를 dfs로 탐색해야 하는 경우이기에 매개변수에 좌표
    public static void dfs(int x, int y, char color){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && nx < N && ny >= 0 && ny < N){
                if(!visited[nx][ny] && picture[nx][ny] == color){
                    dfs(nx, ny, color); // 재귀적 방문
                }
            }
        }

    }
    public static void colorAmblyopia(){
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(picture[i][j] == 'R') {
                    picture[i][j] = 'G';
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                picture[i][j] = line.charAt(j);
            }
        }
        int original = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, picture[i][j]);
                    original++;
                }
            }
        }
        for(boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        colorAmblyopia();
        int colorAmblyopia = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, picture[i][j]);
                    colorAmblyopia++;
                }
            }
        }
        System.out.println(original + " " + colorAmblyopia);

    }
}
