package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


/*
    우선 순위 큐 문제
    최소 우선 순위 큐
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    최대 우선 순위 큐
    PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
 */
public class BOJ1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int result = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            result = result + first + second;
            pq.add(first + second);
        }
        System.out.println(result);
    }
}