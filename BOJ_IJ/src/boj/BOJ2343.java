package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2343 {
	public static boolean canDivide(int[] lessons, int m, int maxSize){
		int count = 1; // 블루레이 개수
		int sum = 0;

		for(int lesson : lessons){
			if(sum + lesson > maxSize){
				count++; // 새 블루레이 사용
				sum = lesson; // 새 블루레이에 현재 강의부터 넣음
			}else{
				sum += lesson;
			}
		}
		return count <=m;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 강의 수
		int M = Integer.parseInt(st.nextToken()); // 블루레이 수

		int[] lessons = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			lessons[i] = Integer.parseInt(st.nextToken());
		}

		int left = Arrays.stream(lessons).max().getAsInt(); // 가장 긴 강의 시간
		// left에 가장 긴 강의를 넣는 이유는 left가 강의 시간보다 작을 경우 블루레이에 들어갈 수가 없음
		int right = Arrays.stream(lessons).sum(); // 전체 강의 시간의 합
		int result = right;

		while(left<=right){
			int mid = (left+right)/2;

			if(canDivide(lessons, M, mid)){
				result = mid;
				right = mid - 1; // 블루레이 더 작은 용량이 되나 확인하러 왼쪽으로
			}else{
				left = mid + 1; // 블루 레이 용량이 작아서 안됐으니 오른쪽으로
			}
		}
		System.out.println(result);

	}
}
