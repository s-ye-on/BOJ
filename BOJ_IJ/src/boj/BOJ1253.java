package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int count =0;
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=0; i<N; i++) {
			int leftPoint = 0;
			int rightPoint = N-1;
			while(leftPoint<rightPoint) {
				if(leftPoint == i){
					leftPoint++;
					continue;
				}
				if(rightPoint == i){
					rightPoint--;
					continue;
				}
				int sum = arr[leftPoint] + arr[rightPoint];
				if(sum == arr[i]) {
					count++;
					break;
				}
				else if(sum < arr[i]) {
					leftPoint++;
				}
				else{
					rightPoint--;
				}
			}
		}
		System.out.println(count);
	}
}
