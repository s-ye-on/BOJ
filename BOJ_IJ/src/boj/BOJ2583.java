package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2583 {
    public static int N, M;
    public static boolean[][] map;
    public static List<Integer> result = new ArrayList<>();
    public static int count = 0; // 영역 세어주는 변수
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int dfs(int startY, int startX){
        int extent =1; //영역의 넓이
        map[startY][startX] = true;
        for(int i=0; i<4; i++){
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];
            if(nextX >= 0 && nextX <M && nextY >= 0 && nextY < N && !map[nextY][nextX]){
                    /*
                    이렇게 하면 재귀에서 돌아온 값을 누적하지 않아서
                    실제 넓이를 구할 수 없
                    extent++;
                    dfs(nextY, nextX);
                     */
                extent += dfs(nextY, nextX);
            }
        }
        return extent;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        int K = Integer.parseInt(st.nextToken()); // 직사각형 갯수
        map = new boolean[N][M];

        //왼쪽 아래 꼭짓점 좌표 + 오른쪽 위 꼭짓점 좌표
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());
            for(int j = leftY; j< rightY; j++){
                for(int k = leftX; k< rightX; k++){
                    //배열의 인덱스와 모눈종이의 좌표는 다르기에 맞춰주기 위해
                    map[N-1-j][k] = true;
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!map[i][j]){
                    int extent = dfs(i, j);
                    result.add(extent);
                    count++;
                }
            }
        }
        Collections.sort(result);
        System.out.println(count);
        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i)+" ");
        }
    }
}
