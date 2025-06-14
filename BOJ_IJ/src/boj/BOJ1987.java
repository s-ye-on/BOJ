package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {
    public static int N, M;
    public static int[][] board;
    public static boolean [] visited = new boolean [26];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int maxCount =1;
    public static void dfs(int y, int x, int count) {
        maxCount = Math.max(maxCount, count);
        int alphabet = board[y][x];
        visited[alphabet] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            /*
            처음에 이렇게 if문을 하나로 만들었었음
            이건 범위가 벗어났을 경우여도 먼저 배열에 접근하기 때문에 예외가 발생할 수 있다
            -> 이중 if문으로 먼저 배열의 크기 안에 있나 확인하고 접근하는 방법으로 해보자
            int nextAlphabet = board[ny][nx];
            if(nx>=0 && ny>=0 && nx<M && ny<N && !visited[nextAlphabet]){
                dfs(ny, nx, count+1);
                visited[nextAlphabet] = false;
            }
            */
            if(nx>=0 && ny>=0 && nx<M && ny<N){
                int nextAlphabet = board[ny][nx];
                if(!visited[nextAlphabet]){
                    dfs(ny, nx, count+1);
                    visited[nextAlphabet] = false; // 백트래킹 : 다른 경로를 탐색하기 위함
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        board = new int[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - 'A';
            }
        }
        dfs(0, 0, 1);
        System.out.println(maxCount);
    }
}
