package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ1541 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();

        st = new StringTokenizer(str, "-");
        int sum = Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            int temp =0;
            StringTokenizer addition = new StringTokenizer(st.nextToken(),"+");
            while(addition.hasMoreTokens()){
                temp += Integer.parseInt(addition.nextToken());
            }
            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }
            else{
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
