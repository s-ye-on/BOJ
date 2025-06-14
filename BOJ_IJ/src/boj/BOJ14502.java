package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    public static int virus =2;
    public static int wall = 1;
    public static int empty = 0;
    public static int N, M;
    public static int [][] lab;
    public static int maxSafeArea =0;
    // 상하좌우
    public static int [] dx = {-1, 1, 0, 0};
    public static int [] dy = {0, 0, -1, 1};
    // 바이러스 퍼지기
    public static void spreadVirus(int [][] tempLab){
        Queue<int[]> queue = new LinkedList<>();
        //바이러스 초기 위치 넣기
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tempLab[i][j] == virus){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            for(int i=0; i <4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx <M && ny >= 0 && ny < N && tempLab[ny][nx] ==0){
                    tempLab[ny][nx] = virus;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }
    public static int getSafeArea(int[][] tempLab){
        int count =0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tempLab[i][j] == empty){
                    count++;
                }
            }
        }
        return count;
    }
    // 벽 3개 세우기 (백트래킹) 백트래킹 : 가능한 모든 경우 탐색
    public static void setWalls(int count){
        if(count == 3){
            // 벽을 세운 후, 바이러스 퍼뜨리기
            int [][] tempLab = new int[N][M];
            for(int i=0; i<N; i++){
                tempLab[i] = lab[i].clone();
            }
            spreadVirus(tempLab);
            maxSafeArea = Math.max(maxSafeArea, getSafeArea(tempLab));
            return;
        }
        // 빈 칸에 벽을 세운다
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(lab[i][j] == empty){
                    lab[i][j] = wall;
                    setWalls(count+1);
                    lab[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기
        lab = new int [N][M];

        //연구소 초기화
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        setWalls(0);
        System.out.println(maxSafeArea);
    }
}
