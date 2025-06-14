package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 투 포인터 알고리즘
 정렬된 배열에서 사용됨
 목적: 두 값의 조합 찾기
 탐색 방식: 양 끝에서 이동하며 탐색 O(N)
 양쪽에서 한 칸씩 이동해가며 탐색하는 방식
 */
public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left =0;
        int right = arr.length-1;
        int min = Integer.MAX_VALUE;
        int answerLeft =0;
        int answerRight = 0;
        while(left < right) {
            int sum = arr[left] + arr[right];
            int absSum = Math.abs(sum);
            if(absSum < min) {
                min = absSum;
                answerLeft = arr[left];
                answerRight = arr[right];
            }
            if(sum <0 ){
                left++;
            }
            else {
                right--;
            }
        }
        System.out.println(answerLeft + " " + answerRight);
    }
}
