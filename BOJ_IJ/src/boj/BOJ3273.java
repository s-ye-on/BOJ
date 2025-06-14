package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
투 포인터
 */
public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int [] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int left = 0;
        int right = N-1;
        int count =0;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target) {
                count++;
                //맞는 값을 확인하고 포인터를 옮겨주지 않으면 무한루프에 빠짐
                left++;
            }
            else if(sum > target) {
                right--;
            }
            else{
                left++;
            }

        }
        System.out.println(count);
    }
}
