package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
투 포인터 알고리즘

sum-=arr[left++];
-> sum -arr[left];
left = left +1;
left++ -> 후위 연산자 : 사용 후 1증가
자동으로 left 변수에 사용 후 ++ 증가 후 저장됨

length == Integer.MAX_VALUE ? 0 : length)
삼항 연산자 또는 조건 연산자라 부름
조건 ? 참일때 값 : 거짓일 때 값
 */

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int [] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int length = Integer.MAX_VALUE;
        int left =0;
        int right = 0;
        int sum =0;
        while(true){
            if(sum >= target){
                length = Math.min(length, right - left);
                sum -= arr[left++];
                // left++ 후위 연산자 -> 사용 후 1증가
                // 자동으로 left 변수에 ++ 증가후 저장됨
            }
            else if(right == N){
                break;
            }
            else{
                sum += arr[right++];
                /*
                sum += arr[right];
                right = right +1;
                과 같음
                 */
            }
        }
        System.out.println(length == Integer.MAX_VALUE ? 0 : length); // 삼항 연산자 또는 조건 연산자라고 부름
        // 조건 ? 참일때 값 : 거짓일 때 값
    }
}
