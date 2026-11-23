package boj.boj1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 전체 : O(N log N + M log N)
public class Boj1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arrN = new int[N];

		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		// 정렬 O(N long N)
		Arrays.sort(arrN);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arrM = new int[M];

		for (int i = 0; i < M; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}

		// O(M log N)
		for (int i = 0; i < M; i++) {
			int current = arrM[i];
			sb.append(binarySearch(arrN, current)).append("\n");
		}
		System.out.println(sb);
	}

	// O(log N)
	public static int binarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		int mid = (low + high) / 2;
		while (low <= high) {
			if (arr[mid] < target) {
				low = mid + 1;
				mid = (low + high) / 2;
			} else if (arr[mid] > target) {
				high = mid - 1;
				mid = (low + high) / 2;
			} else {
				return 1;
			}
		}
		return 0;
	}
}
