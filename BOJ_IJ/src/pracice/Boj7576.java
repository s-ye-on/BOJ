package pracice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {
	public static int N, M;
	public static boolean[][] visited;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static final int RIPE = 1;
	public static final int UNRIPE = 0;
	public static final int EMPTY = -1;
	public static int[][] box;
	public static Queue<int[]> queue = new LinkedList<>();

	public static int bfs(){
		int days = -1;
		while(!queue.isEmpty()){
			int size = queue.size();
			days++;
			for(int i=0; i<size; i++) {
				int[] arr = queue.poll();
				int y = arr[0];
				int x = arr[1];

				for(int j=0; j<4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					if(0<= ny && ny < N && 0<= nx && nx < M && box[ny][nx] == UNRIPE) {
						box[ny][nx] = RIPE;
						queue.offer(new int[]{ny, nx});
					}
				}
			}
		}
		return days;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로

		box = new int[N][M];
		visited = new boolean[N][M];

		int isUnripeCount =0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == RIPE) {
					queue.offer(new int[]{i, j});
				}
				else{
					isUnripeCount++;
				}
			}
		}
		if(isUnripeCount == 0){
			System.out.println(0);
			return;
		}
		int days = bfs();
		for(int[] row : box){
			for(int tomato : row){
				if(tomato == UNRIPE) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(days);
	}
}
