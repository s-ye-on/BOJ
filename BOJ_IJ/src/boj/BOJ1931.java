package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;
import java.util.function.BiFunction;

public class BOJ1931 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [][] meetings = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }
        /*
        람다
        ()안에 있는 것 매개 변수, {} 실핼할 로직
        익명 함수라고도 함

         */
        Arrays.sort(meetings, (a, b)->{
            if(a[1] == b[1]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int count =0;
        int endTime =0;

        for(int [] meeting : meetings) {
            if(meeting[0] >= endTime){
                count++;
                endTime = meeting[1];
            }
        }
        System.out.println(count);

        BiFunction<Integer,Integer,Integer> func = (a, b)->a+b;
        int result = func.apply(1,3);
        System.out.println(result);
    }
}