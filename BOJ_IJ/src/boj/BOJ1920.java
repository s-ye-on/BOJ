package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
public class BOJ1920 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        int [] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<M; i++){
            int compare = Integer.parseInt(st.nextToken());
            if(binarySearch(arr, compare) >= 0){
                sb.append(1).append("\n");
            }
            else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int binarySearch(int [] arr , int key){
        int hi = arr.length-1;
        int lo = 0;

        while (lo<= hi){
            int mid = (hi + lo)/2;
            if(key > arr[mid]){
                lo = mid +1;
            }
            else if(key < arr[mid]){
                hi = mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
