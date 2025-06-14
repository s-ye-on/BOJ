package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2573 {
    public static int N, M;
    public static int[][] map;
    public static int[][] newMap;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] visited;
    public static void melting(int y, int x){
        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny<N && ny>=0 && nx<M && nx>=0){
                int neighbor = map[ny][nx];
                if(neighbor==0){
                    map[y][x]--;
                }
            }
        }
    }
    public static int countIcebergs(){
        //dfs로 만들자!
        visited = new boolean[N][M];
        int count =0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]!=0 && !visited[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(int y, int x){
        visited[y][x] = true;
        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny<N && ny>=0 && nx<M && nx>=0){
                if(map[ny][nx]!=0 && !visited[ny][nx]){
                    dfs(ny, nx);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int year =0;
        while(true){
            int iceBergsCount = countIcebergs();
            if(iceBergsCount>=2){
                System.out.println(year);
                break;
            }
            if(iceBergsCount==0){
                System.out.println(0);
                break;
            }
            newMap = new int[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]>0){
                        int water =0;
                        for( int d =0; d<4; d++){
                            int ni = i + dy[d];
                            int nj = j + dx[d];
                            if(ni>=0 && ni<N && nj>=0 && nj<M){
                                if(map[ni][nj]==0)water++;
                            }
                        }
                        newMap[i][j] = Math.max(0, map[i][j] - water);
                    }
                }
            }
            map = newMap;
            year++;
        }
    }
}
