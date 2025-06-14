package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    public static int[] arr;
    public static int canInstall(int distance){
        // 첫 번째 집은 무조건 설치한다고 가정
        int count = 1;
        int lastLocate = arr[0];
        for(int i=1; i<arr.length; i++) {
            int locate = arr[i];
            if(locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 집 갯수
        int C = Integer.parseInt(st.nextToken()); // 공유기 갯수

        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int low = 1; // 최소 거리가 가질 수 있는 최솟값
        int high = arr[N-1] - arr[0] +1;

        while(low < high) {
            int mid = (low + high)/2;
            if(canInstall(mid) < C) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        System.out.println(low -1);
    }
}
