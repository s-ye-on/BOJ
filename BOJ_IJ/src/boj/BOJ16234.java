package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16234 {
	public static int[][] map;
	public static int N, L, R;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static boolean[][] visited;
	public static boolean moved = false;

	public static boolean checkAlliance(int y, int x, int y2, int x2) {
		if(y2 < 0 || y2 >= N || x2 < 0 || x2 >= N){
			return false;
		}
		int diff = Math.abs(map[y][x] - map[y2][x2]);
		return diff >= L && diff <= R;
	}

	public static void bfs(int y, int x){
		Queue<int[]> queue = new LinkedList<>();
		List<int[]> alliance = new ArrayList<>();

		queue.offer(new int[]{y,x});
		alliance.add(new int[]{y,x});
		visited[y][x] = true;

		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			for(int i=0; i<4; i++){
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];

				if(ny<N && ny>=0 && nx<N && nx>=0 && !visited[ny][nx] && checkAlliance(cur[0], cur[1], ny, nx)){
					visited[ny][nx] = true;
					queue.offer(new int[]{ny,nx});
					alliance.add(new int[]{ny,nx});
				}
			}
		}
		// 인구 이동
		if(alliance.size() >1){
			//연합이 2개 이상일 때만 인구 이동
			int sum = 0;
			for(int[] country : alliance){
				sum += map[country[0]][country[1]];
			}
			int avg = sum / alliance.size();
			for(int[] country : alliance){
				map[country[0]][country[1]] = avg;
			}
			moved = true; // 하루 동안 인구 발생 표시
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];


		for(int i=0; i<N; i++) {
			line = br.readLine();
			st = new StringTokenizer(line);
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 두 나라 사이의 인구수 차이가 L과R 사이이면 국경이 열림
		// 국경이 몇일동안 열리는지 구해야
		int days =0;
		while(true){
			moved = false;
			visited = new boolean[N][N];

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]){
						bfs(i, j);
					}
				}
			}
			if(!moved) break; // 인구 이동 없으면 종료
			days++;
		}
		System.out.println(days);
	}
}
