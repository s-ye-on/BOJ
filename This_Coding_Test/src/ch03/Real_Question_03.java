package ch03;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

//page 96
// 숫자 카드 게임
public class Real_Question_03 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str);

        //행의 개수
        int N = Integer.parseInt(st.nextToken());
        //열의 개수
        int M = Integer.parseInt(st.nextToken());

        //작은수들 담을 그릇
        int [] arr1 = new int[N];
        for(int i=0; i<N; i++){
            int [] arr2 = new int[M];
            String str2 = br.readLine();
            st = new StringTokenizer(str2);

            for(int j=0; j<M; j++){
                arr2[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr2);
            arr1[i] = arr2[0];
        }
        Arrays.sort(arr1);
        int out = arr1[N-1];
        System.out.println(out);

    }
}
