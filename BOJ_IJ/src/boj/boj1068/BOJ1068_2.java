package boj.boj1068;

import java.io.*;
import java.util.*;

public class BOJ1068_2 {
	/*
		이 코드에서는 deleteNodes() 메서드를 따로 두지 않고, dfs로 탐색 시 삭제한 노드는 건너 뛰고 탐색만 하여 정답 도출
	 */
	static int N, deleteNode, leafCount = 0;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void dfs(int node) {
		visited[node] = true;
		boolean isLeaf = true;

		for (int next : graph[node]) {
			if (next == deleteNode) continue;
			isLeaf = false;
			dfs(next);
		}

		if (isLeaf) leafCount++;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = -1;
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) root = i;
			else graph[parent].add(i);
		}

		deleteNode = Integer.parseInt(br.readLine());
		if (deleteNode == root) {
			System.out.println(0);
			return;
		}

		dfs(root);
		System.out.println(leafCount);
	}
}