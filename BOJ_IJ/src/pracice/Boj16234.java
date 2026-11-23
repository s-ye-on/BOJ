package pracice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16234 {
	public static int N, L, R;
	public static boolean moved;
	public static int[][] map;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static boolean[][] visited;
	public static boolean checkAlliance(int y, int x, int y2, int x2){
		if(y>N || y<0 || x>N || x2>N || x2<0) return false;
		int diff = Math.abs(map[y][x] - map[y2][x2]);
		return L<= diff && R<= diff;
	}

	public static void bfs(int y, int x){
		Queue<int[]> queue = new LinkedList<>();
		List<int[]> alliance = new ArrayList<>();
		visited[y][x] = true;
		queue.offer(new int[]{y, x});

		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			for(int i=0; i<4; i++){
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];

				if(ny<=0 && ny<N && nx<=0 && nx<N && !visited[ny][nx] && checkAlliance(cur[0], cur[1], ny, nx)){
					visited[ny][nx] = true;
					alliance.add(new int[]{ny, nx});
					queue.offer(new int[]{ny, nx});
				}
			}
		}

		if(alliance.size()>1){
			int sum = 0;
			for(int[] country : alliance){
				sum += map[country[0]][country[1]];
			}
			int avg = sum/alliance.size();
			for(int[] country : alliance){
				map[country[0]][country[1]] = avg;
			}
			moved = true;
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

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int days =0;
		while(true){
			moved = false;

			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(!visited[i][j]){
						bfs(i, j);
					}
				}
			}
			if(!moved) break;
			days++;
		}
		System.out.println(days);
	}
}
