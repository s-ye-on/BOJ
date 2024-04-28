package practice;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ1010 {
    public static void main(String [] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine()," ");
            long N = Integer.parseInt(st.nextToken());
            long M = Integer.parseInt(st.nextToken());
            long out =1;
            long min = M-N;
            for(long j=M; j>0; j--){
                out *= j;
            }
            for(long k=N; k>0; k--){
                out /=k;
            }
            for(long l=min; l>0; l--){
                out /=l;
            }
            sb.append(out).append("\n");
        }
        System.out.println(sb);
    }
}
