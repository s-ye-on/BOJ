package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;


// 2108
public class BOJ2563 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int x_length = 100;
        int y_length = 100;
        boolean [][] paper = new boolean[x_length][y_length];
        // 배열 기본 값 0

        int color_paper = Integer.parseInt(br.readLine());
        int black_sum = 0;

        for (int i = 0; i < color_paper; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    paper[j][k] = true;
                }
            }
        }
        for (int j = 0; j < x_length; j++) {
            for (int k = 0; k < y_length; k++) {
                if (paper[j][k]) {
                    black_sum++;
                }
            }
        }
        System.out.println(black_sum);
    }
}