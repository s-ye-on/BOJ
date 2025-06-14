package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                arr[i][j] = i*j;
            }
        }
        int temp =0;
        int [] oneDimension = new int[N*N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                oneDimension[temp] = arr[i][j];
                temp++;
            }
        }
        Arrays.sort(oneDimension);
        System.out.println(oneDimension[K]);
    }
}
