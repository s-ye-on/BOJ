package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ1520 {
    // dfs + dp 문제 경로 갯수 세는
    public static int N, M;
    public static int[][] map;
    public static int[][] dp;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int dfs(int y, int x) {
        // 경로의 수를 세는 문제 -> dfs 적절
        if(y== N-1 && x== M-1) return 1;
        if(dp[y][x] != -1) return dp[y][x];
        dp[y][x] = 0;
        for(int i=0; i<4; i++) {
            int ny = y+dx[i];
            int nx = x+dy[i];
            if(ny>=0 && ny<N && nx>=0 && nx<M) {
                if(map[y][x] > map[ny][nx]) {
                    dp[y][x] += dfs(ny, nx);
                }
            }
        }
        return dp[y][x];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        map = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        int result = dfs(0, 0);
        System.out.println(result);
    }
}

