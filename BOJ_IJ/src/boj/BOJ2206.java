package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
    public static int[][] map;
    public static int N, M;
    public static boolean[][][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static class Node{
        int y, x, dist, broken;
        Node(int y, int x, int dist, int broken) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.broken = broken; //0: 안부숨 1: 부숨
        }
    }
    public static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.y == N-1 && cur.x == M-1){
                return cur.dist;
            }
            for(int d =0; d<4; d++){
                int ny = cur.y+dy[d];
                int nx = cur.x+dx[d];
                if(nx<0 || ny <0 || ny >=N || nx>= M) continue;

                //다음칸이 길이고, 아직 안간 곳
                if(map[ny][nx] == 0 && !visited[ny][nx][cur.broken]){
                    visited[ny][nx][cur.broken] = true;
                    queue.offer(new Node(ny,nx,cur.dist+1,cur.broken));
                }
                //다음칸이 벽이고 아직 벽이 안부순 경우
                else if(map[ny][nx] == 1 && cur.broken ==0 && !visited[ny][nx][1]){
                    visited[ny][nx][1] = true;
                    queue.offer(new Node(ny, nx, cur.dist+1, 1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }
}
