package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            LinkedList<int[]> queue = new LinkedList<>();
            for(int i=0; i<n; i++) {
                queue.offer(new int[] {i, Integer.parseInt(st.nextToken())});
            }
            int count =0;

            while(!queue.isEmpty()) {
                boolean isMax = true;
                int [] front = queue.poll();

                for(int i=0; i<queue.size(); i++) {
                    if(front[1] < queue.get(i)[1]) {
                        queue.offer(front);
                        for(int j=0; j<i; j++){
                            queue.offer(queue.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                if(!isMax){
                    continue;
                }
                count++;
                if(front[0] == m){
                    break;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
