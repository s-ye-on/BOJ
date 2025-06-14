package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = N-1;
        int minSum = Integer.MAX_VALUE;
        int ansLeft =0;
        int ansRight = 0;
        // Math.abs() -> 절대값 반환 함수
        while(left < right) {
            int temp = arr[left] + arr[right];
            if(Math.abs(temp) < minSum) {
                minSum = Math.abs(temp);
                ansLeft = arr[left];
                ansRight = arr[right];
            }
            if(temp >0) {
                right--;
            }
            else {
                left++;
            }
        }
        System.out.println(ansLeft + " " + ansRight);
    }
}
