package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2667 {
    public static int n;
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static List<Integer> houseCounts = new ArrayList<>();
    public static int dfs(int x, int y) {
        map[x][y] = 0;
        int count = 1;

        for(int i=0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newX < n && newY >= 0 && newY < n && map[newX][newY] == 1) {
                count += dfs(newX, newY);
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        //지도 초기화
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j]==1) {
                    int count = dfs(i, j);
                    houseCounts.add(count);
                }
            }
        }
        Collections.sort(houseCounts);
        System.out.println(houseCounts.size());
        for(int count : houseCounts) {
            System.out.println(count);
        }
    }
}
