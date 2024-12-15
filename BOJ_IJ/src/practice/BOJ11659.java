package practice;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class BOJ11659 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이 문제는 배열의 부분 합을 미리 배열에 넣어놓고
        // 배열의 범위에 따라 미리 계산된 값들이나오게 만들어야 시간 초과가 발생하지 않음
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int [] arr = new int[N+1];
        arr[0] = 0;
        for(int i=0; i<N; i++){
            arr[i+1] = arr[i] + scanner.nextInt();
        }
        for(int i=0; i<M; i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            System.out.println(arr[end] - arr[start -1]);
        }
    }
}