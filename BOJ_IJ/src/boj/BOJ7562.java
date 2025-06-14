package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7562 {
    public static int[][] board;
    public static int I;
    public static int startX, startY, targetX, targetY;
    public static int[] dy = {-2, -2, -1 ,-1, 1, 1, 2, 2};
    public static int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static int bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        board[y][x] = 0;
        int count = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];
            if(nowY == targetY && nowX == targetX){
                return board[nowY][nowX];
            }
            for(int i=0; i<8; i++){
                int newY = nowY + dy[i];
                int newX = nowX + dx[i];
                if(newY >=0 && newY<I && newX>=0 && newX<I && board[newY][newX] == -1){
                    board[newY][newX] =board[nowY][nowX]+1;
                    queue.offer(new int[]{newY, newX});
                }
            }
        }
        return 0; //목표 좌표에 도달하지 못한 경우
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for(int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            board = new int[I][I];
            for(int j = 0; j < I; j++) {
                for(int k = 0; k < I; k++) {
                    board[j][k] = -1;
                }
            }
            st = new StringTokenizer(br.readLine());
            startY = Integer.parseInt(st.nextToken());
            startX = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            targetY = Integer.parseInt(st.nextToken());
            targetX = Integer.parseInt(st.nextToken());
            int result = bfs(startY, startX);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
