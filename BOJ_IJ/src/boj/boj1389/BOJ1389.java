package boj.boj1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1389 {
	public static int N;
	public static int M;
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visited;
	public static int[] distance;
	public static void bfs(int start){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		// offer() : 큐가 꽉 찬 경우 false 반환, add() : 큐가 꽉 찬 경우 IllegalStatementException 에러 발생
		// 큐에 넣을 때 방문체크 + 거리갱신
		visited[start] = true;
		distance[start] = 0;
		while(!queue.isEmpty()){
			int now = queue.poll();
			for(int link : graph.get(now)){
				if(!visited[link]){
					visited[link] = true;
					distance[link] = distance[now] + 1;
					queue.offer(link);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 유저 수
		M = Integer.parseInt(st.nextToken()); // 간선 수
		visited = new boolean[N+1];
		distance = new int[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++){
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		int[] result = new int[N+1];
		int resultIndex = 0;
		int resultValue = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++){
			Arrays.fill(distance, 0);
			Arrays.fill(visited, false);
			bfs(i);

			for(int j =1; j<=N; j++){
				result[i] += distance[j];
			}
			if(result[i] < resultValue){
				resultIndex = i;
				resultValue = result[i];
			}
		}
		System.out.println(resultIndex);
	}
}
