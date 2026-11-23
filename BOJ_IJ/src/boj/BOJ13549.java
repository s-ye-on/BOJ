package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*
    가중치가 0과 1인 그래프 탐색 문제
    0-1 BFS 사용 (가중치가 0과 1만 있을 때 사용)
    자료구조 덱 사용
    순간 이동은 덱 앞에 추가(가중치0), 이동은 덱 뒤에 추가(가중치 1)
    덱의 앞 -> 즉시 처리 | 덱의 뒤 -> 나중에 처리
 */
public class BOJ13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // 최대한 순간이동 후 이동이 가장 빠름
        int[] distance = new int[100001];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[N] = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(N);
        while (!deque.isEmpty()) {
            int now = deque.poll();
            if(now == K) break;

            // 순간 이동(가중치 0)
            if(now *2 <= 100000 && distance[now *2] > distance[now]) {
                distance[now*2] = distance[now];
                deque.addFirst(now * 2); // 0초니까 앞에
            }
            //걷기 (가중치 0)
            if(now +1 <= 100000 && distance[now+1] > distance[now] +1) {
                distance[now +1] = distance[now] + 1;
                deque.addLast(now+1);
            }
            if(now -1 >=0 && distance[now-1] > distance[now] +1){
                distance[now-1] = distance[now] +1;
                deque.addLast(now-1);
            }
        }
        System.out.println(distance[K]);
    }
}
