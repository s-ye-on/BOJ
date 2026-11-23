package boj.boj1068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1068 {
	public static int deleteNode;
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;
	public static int leafCount =0;
	public static void dfs(int node) {
		if(node == deleteNode) return;
		if(graph[node].isEmpty()) {
			leafCount++;
			return;
		}
		visited[node] = true;
		for(int next : graph[node]) {
			if(!visited[next]) {
				if(next == deleteNode) continue;
				dfs(next);
			}
		}
	}
	public static void deleteNodes(int startNode){
		for(int i = 0; i<graph.length; i++) {
			// 값을 지우고 싶을 때는 graph[i].remove(startNode); 대신 graph[i].remove(Integer.valueOf(startNode)); 이렇게 하자
			graph[i].remove(Integer.valueOf(startNode));
		}
		/*
			여기서 오류가 나는데, 그래프에서 child로 불러와서 바로 삭제하니까 실시간으로 리스트 크기에 변동이 생겨서 문제가 생기는 것
			이럴 때 리스트를 미리 복사해놓고 for-each문으로 삭제하자!
			이전엔 for-each 문에 바로 graph[startNode] 넣었었음
		 */
		ArrayList<Integer> children = new ArrayList<>(graph[startNode]);
		for(int child : children) {
			deleteNodes(child);
		}
		graph[startNode].clear();
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //노드의 개수
		graph = new ArrayList[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = -1;
		for(int i=0; i<N; i++) {
			int link = Integer.parseInt(st.nextToken());
			if(link == -1) root = i;
			else graph[link].add(i);
		}
		deleteNode = Integer.parseInt(br.readLine());
		if(deleteNode == root) {
			System.out.println(0);
			return;
		}
		deleteNodes(deleteNode);
		dfs(root);
		System.out.println(leafCount);
	}
}
