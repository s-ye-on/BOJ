package ch04;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Real_Question_03 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String map_size = br.readLine();
        st = new StringTokenizer(map_size);
        int n = Integer.parseInt(st.nextToken()); // 세로크기
        int m = Integer.parseInt(st.nextToken()); // 가로크기

        String character = br.readLine();
        st = new StringTokenizer(character);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

    }
}
