package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int count =0;

        System.out.println(algorithm(X, count));
    }
    // 재귀 사용
    public static int algorithm(int X, int count){
        if(X < 2){
            return count;
        }
        return Math.min(algorithm(X/2, count +1 + (X%2)), algorithm(X/3, count +1 + (X%3)));
    }
}