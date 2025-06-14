package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[N];
        int[] arr2 = new int[M];
        List<Integer> list = new ArrayList<>();
       st = new StringTokenizer(br.readLine(), " ");
       for(int i=0; i<N; i++) {
           arr1[i] = Integer.parseInt(st.nextToken());
       }
       st = new StringTokenizer(br.readLine(), " ");
       for(int i=0; i<M; i++) {
           arr2[i] = Integer.parseInt(st.nextToken());
       }

       int left1 =0;
       int left2 = 0;
       while(left1<N && left2 < M){
           int result1 = arr1[left1];
           int result2 = arr2[left2];
           if(result1 < result2){
               list.add(result1);
               left1++;
           }
           else{
               list.add(result2);
               left2++;
           }
       }
       while(left1<N){
           list.add(arr1[left1]);
           left1++;
       }
       while(left2<M){
           list.add(arr2[left2]);
           left2++;
       }
        for(int result : list) {
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
