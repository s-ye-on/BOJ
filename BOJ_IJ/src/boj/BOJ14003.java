package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 이 문제 어렵다 다시 한 번 보자
public class BOJ14003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 수열의 길이
		int[] nums = new int[N];
		int[] index = new int[N];
		int[] prev = new int[N];
		List<Integer> lis = new ArrayList<>();
		List<Integer> lisIndices = new ArrayList<>(); // LIS 실제 인덱스 저장

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int[] tails = new int[N]; // LIS 구성하는 값들 (값만)
		int len =0;

		for(int i=0; i<N; i++) {
			int pos = Arrays.binarySearch(tails,0, len, nums[i]);
			if(pos < 0) pos = -(pos + 1); // binarySerch는 값이 없으면 음수를 리턴하므로 실제 들어갈 위치로 변환

			tails[pos] = nums[i];
			index[i] = pos;
			if(pos == len){
				len++;
			}

			// 역추적을 위한 이전 값 저장
			prev[i] = (pos == 0) ? -1 : findLastIndex(index, pos-1, i-1);
		}
		System.out.println(len);

		// LIS 수열 실제 값 역추적
		int current = -1;
		for( int i= N-1; i>=0; i--) {
			if(index[i] == len -1){
				current = i;
				break;
			}
		}
		Stack<Integer> result = new Stack<>();
		while(current != -1) {
			result.push(nums[current]);
			current = prev[current];
		}
		while(!result.isEmpty()) {
			System.out.println(result.pop()+ " ");
		}
	}
	// 이전 인덱스를 찾기 위한 헬퍼 메서드
	private static int findLastIndex(int[] index, int target, int end) {
		for( int i= end; i>=0; i--) {
			if(index[i] == target) return i;
		}
		return -1;
	}
}
