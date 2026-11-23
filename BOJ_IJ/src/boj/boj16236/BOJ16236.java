package boj.boj16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236 {
	public static int N;
	public static int[][] map;
	public static int startY, startX;
	public static int sharkSize = 2;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int time =0;
	public static int eatCount =0;
	public static List<int[]> edibleFish;
	public static boolean[][] visited;
	public static void bfs(List<int[]> edibleFish) {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{startY, startX, 0});
		visited[startY][startX] = true;
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int curY = arr[0];
			int curX = arr[1];
			int dist = arr[2];

			for(int i=0; i<4; i++) {
				int newY = curY + dy[i];
				int newX = curX + dx[i];

				if(newY < 0 || newY >= N || newX < 0 || newX >= N) continue;
				if(visited[newY][newX] || map[newY][newX] > sharkSize) continue;

				visited[newY][newX] = true;
				queue.offer(new int[]{newY, newX, dist+1});
				if(map[newY][newX] !=0 && map[newY][newX] < sharkSize) {
					edibleFish.add(new int[]{newY, newX, dist+1});
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int token = Integer.parseInt(st.nextToken());
				if(token == 9) {
					startY = i;
					startX = j;
					map[i][j] = 0;
				}
				else{
					map[i][j] = token;
				}
			}
		}
		while(true) {
			edibleFish = new ArrayList<>();
			visited = new boolean[N][N];
			bfs(edibleFish);
			if(edibleFish.isEmpty()) break;

			Collections.sort(edibleFish, (a,b)->{
				if(a[2] != b[2]) return a[2] - b[2];
				if(a[0] != b[0]) return a[0] - b[0];
				return a[1] - b[1];
			});
			int[] fish = edibleFish.get(0);
			int fishY = fish[0];
			int fishX = fish[1];
			int fishDist = fish[2];
			map[fishY][fishX] = 0;
			time += fishDist;
			eatCount++;
			if(sharkSize == eatCount){
				sharkSize++;
				eatCount = 0;
			}
			startY = fishY;
			startX = fishX;
		}
		System.out.println(time);
	}
}
