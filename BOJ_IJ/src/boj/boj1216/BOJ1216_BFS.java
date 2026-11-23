package boj.boj1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
class Point {
    int y,x;
    public Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}
public class BOJ1216_BFS {
    /*
        BFS로 풀이
        0-1 BFS
     */
    public static int M, N;
    public static int[][] map;
    public static int[][] distance;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void bfs(){
        Deque<Point> deque = new LinkedList<>();
        deque.add(new Point(0, 0));
        distance[0][0] = 0;

        while(!deque.isEmpty()){
            Point current = deque.poll();
            for(int i=0; i<4; i++) {
                int newY = current.y + dy[i];
                int newX = current.x + dx[i];

                if(newX <0 || newY <0 || newX >= M || newY >= N) continue;
                int cost = map[newY][newX];
                int newDistance = distance[current.y][current.x] + cost;
                if(distance[newY][newX] > newDistance) {
                    distance[newY][newX] = newDistance;

                    if(cost == 0){
                        deque.addFirst(new Point(newY, newX));
                    }
                    else{
                        deque.addLast(new Point(newY, newX));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        map = new int[N][M];
        distance = new int[N][M];

        for(int i=0; i<N; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(distance[N-1][M-1]);
    }
}
