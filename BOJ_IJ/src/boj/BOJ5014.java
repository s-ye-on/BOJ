package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014 {
	public static int F;
	public static int S;
	public static int G;
	public static int U;
	public static int D;
	public static boolean[] visited;
	public static void bfs(){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{S, 0});
		visited[S] = true;
		while(!queue.isEmpty()){
			int[] arr = queue.poll();
			int position = arr[0];
			int count = arr[1];
			// 1. position이 F보다 작은지 2. position에 U할 수 있는지 3. position에 D할 수 있는지 4. position이 G인지 G인 경우 return
			// count를 저장하는 방법이 두개가 있음 1. queue에 직접 같이 저장 2. visited 배열을 만든 후 boolean이 아닌 int로 만들어서 저장
			if(position == G){
				System.out.println(count);
				return;
			}
			if(position+U <= F && !visited[position+U] ){
				queue.offer(new int[] {position+U, count+1});
				visited[position+U] = true;
			}
			if(position-D >=1 && !visited[position-D]){
				queue.offer(new int[] {position-D, count+1});
				visited[position-D] = true;
			}
		}
		System.out.println("use the stairs");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new boolean[F+1];
		bfs();

	}
}
