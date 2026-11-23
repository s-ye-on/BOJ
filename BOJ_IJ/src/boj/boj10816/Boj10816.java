package boj.boj10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			input(map, input);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int result = count(map, target);
			sb.append(result).append(' ');
		}

		System.out.print(sb);
	}

	public static void input(Map<Integer, Integer> map, int input) {
		if (map.containsKey(input)) {
			map.put(input, map.get(input) + 1);
		} else {
			map.put(input, 1);
		}
	}

	public static int count(Map<Integer, Integer> map, int target) {
		if (map.containsKey(target)) {
			return map.get(target);
		} else {
			return 0;
		}
	}
}
