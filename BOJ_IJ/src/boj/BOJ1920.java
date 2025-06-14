package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int [] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int m = Integer.parseInt(br.readLine());
        int [] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        for(int i =0; i<m; i++){
            boolean found = false;
            int target = arr2[i];
            int left = 0;
            int right = n-1;
            while(left <= right){
                int mid = (left + right)/2;
                if(arr1[mid] == target){
                    sb.append(1).append("\n");
                    found = true;
                    break;
                }
                else if(arr1[mid] > target){
                    right = mid -1;
                }
                else{
                    left = mid +1;
                }
            }
            if(!found){
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
