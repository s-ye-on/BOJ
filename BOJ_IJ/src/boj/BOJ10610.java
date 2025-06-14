package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        /*
        각 자리수의 합이 3의 배수이면 3의 배수이다
        가장 큰 수는 각 자리수를 정렬하면 됨 정렬 한 후 판별 -> 출력
         */
        char[] arr = input.toCharArray();
        // 오름 차순
        Arrays.sort(arr);

        int sum =0;
        for(int i= arr.length-1; i>=0; i--) {
            int num = arr[i] - '0';
            sum += num;
            sb.append(num);
        }
        if(sum % 3 != 0 || arr[0] != '0'){
            System.out.println(-1);
            return;
        }
        System.out.println(sb);
    }
}
