package practice;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
public class BOJ1620 {
    public static void main(String [] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> hashMap1 = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();

        for(int i=1; i<=N; i++){
            String name = br.readLine();
            hashMap1.put(i, name);
            hashMap2.put(name, i);
        }

        for(int i=0; i<M; i++){
            String str = br.readLine();
            if(49<=str.charAt(0) && str.charAt(0)<=57){
                sb.append(hashMap1.get(Integer.parseInt(str))).append("\n");
            }
            else{
                sb.append(hashMap2.get(str)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
