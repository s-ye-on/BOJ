package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class BOJ11047 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st;
        st = new StringTokenizer(str, " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int sum =0;
        int [] coin = new int[N];
        for(int i=0; i<coin.length; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        for(int i=coin.length -1; i >= 0; i--){
            if(coin[i] <= K){
                sum += (K/coin[i]);
                K = K % coin[i];
            }
        }
        System.out.println(sum);
    }
}