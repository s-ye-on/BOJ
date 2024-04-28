package ch03;

//page.92
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.IOException;

public class Real_Question_02 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str1 = br.readLine();
        st = new StringTokenizer(str1);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String str2 = br.readLine();
        st = new StringTokenizer(str2);
        int [] arr = new int[st.countTokens()];

        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int first = arr[N-1];
        int second = arr[N-2];

        int result =0;
        while(true){
            for(int i=0; i<K; i++){
                result += first;
                M -=1;
            }
            result += second;
            M -=1;
            if(M==0){
                break;
            }
        }
        System.out.println(result);
    }
}
