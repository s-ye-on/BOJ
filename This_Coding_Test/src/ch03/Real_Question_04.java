package ch03;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

// page 99
// 1이 될때까지

public class Real_Question_04 {
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 0;

        while(true){
            if(N %K ==0){
                N = N/K;
                result++;
            }
            else{
                N -=1;
                result++;
            }
            if (N == 1){
                break;
            }
        }
        System.out.println(result);
    }
}
