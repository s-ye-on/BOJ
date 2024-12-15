package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;
public class BOJ9935 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String out = br.readLine();
        int str_len = str.length();
        int out_len = out.length();

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str_len; i++){
            int count =0;
            stack.push(str.charAt(i));
            if(stack.size() >=out_len){
                for(int j=0; j<out_len; j++){
                    if(stack.get(stack.size()-out_len +j) == out.charAt(j)){
                        count ++;
                    }
                    if(count == out_len){
                        for(int k=0; k<out_len; k++){
                            stack.pop();
                        }
                    }
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }
        else{
            for(char ch: stack){
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }
}
