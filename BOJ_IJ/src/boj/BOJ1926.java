package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1926 {
    public static int N, M;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int dfs(int length, int width) {
        visited[length][width] = true;
        int area = 1;
        for (int i = 0; i < 4; i++) {
            int ny = length + dy[i];
            int nx = width + dx[i];
            if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    area += dfs(ny, nx);
                }
            }
        }
        return area;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count =0;
        int maxArea =0;
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                if(map[i][j] ==1 && !visited[i][j]) {
                    int area = dfs(i, j);
                    count++;
                    if(area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
    }
}
