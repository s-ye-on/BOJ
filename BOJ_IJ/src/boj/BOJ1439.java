package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int count0 =0;
        int count1 =0;

        if(input.charAt(0)=='0'){
            count0++;
        }else{
            count1++;
        }
        for(int i = 1; i < input.length(); i++){
            if(input.charAt(i)!= input.charAt(i-1)){
                if(input.charAt(i)=='0'){
                    count0++;
                }else{
                    count1++;
                }
            }
        }
        System.out.println(Math.min(count0,count1));
    }
}
