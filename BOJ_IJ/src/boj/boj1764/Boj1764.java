package boj.boj1764;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1764 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> hashMap = new HashMap<String, Integer>();

		for (int i = 0; i < N; i++) {
			hashMap.put(br.readLine(), 0);
		}

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (hashMap.containsKey(name)) {
				list.add(name);
			}
		}

		Collections.sort(list);
		System.out.println(list.size());
		for (String name : list) {
			System.out.println(name);
		}
	}
}
