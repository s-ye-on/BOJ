package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    /*
    BFS 최적화
    1. 불필요한 visited 배열 제거 (이 풀이 방법처럼)
    2. 큐에 중복된 노드를 넣지 않기
    3. 큐에서 꺼내자마자 처리
     */
    public static int M, N, H;
    public static int [][][] box;
    public static final int RIPENS = 1;
    public static final int UN_RIPENS = 0;
    public static final int EMPTY = -1;
    public static int[] dx = {-1,1,0,0,0,0};
    public static int[] dy = {0,0,-1,1,0,0};
    public static int [] dz = {0,0,0,0,-1,1};
    public static Queue<int[]> queue = new LinkedList<>();
    public static void bfs() {
        while(!queue.isEmpty()) {
            int [] cur = queue.poll();
            int z = cur[0];
            int y = cur[1];
            int x = cur[2];
            for(int i=0; i<6; i++){
                int nX = x + dx[i];
                int nY = y + dy[i];
                int nZ = z + dz[i];
                if(nZ >=0 && nY >=0 && nX >=0 && nZ<H && nY< N && nX<M && box[nZ][nY][nX] == UN_RIPENS){
                    box[nZ][nY][nX] = box[z][y][x] +1; // 날짜 증가
                    queue.offer(new int[]{nZ,nY,nX});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이
        // 3차원 배열 높이, 세로, 가로 순으로 선
        box = new int[H][N][M];

        for(int h=0; h<H; h++) {
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int m=0; m<M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if(box[h][n][m] == RIPENS) {
                        queue.offer(new int[]{h,n,m});
                    }
                }
            }
        }
        bfs();
        int maxDays =0;
        for(int h=0; h<H; h++) {
            for(int n=0; n<N; n++) {
                for(int m=0; m<M; m++) {
                    if(box[h][n][m] == UN_RIPENS) {
                        System.out.println(-1);
                        return;
                    }
                    maxDays = Math.max(maxDays, box[h][n][m]);
                }
            }
        }
        System.out.println(maxDays-1);
    }
}
