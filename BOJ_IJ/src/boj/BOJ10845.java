package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;


// 2108
public class BOJ10845 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Deque<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            command(str, queue);

        }
    }
    public static void command(String str, Deque<Integer> queue) {
        StringTokenizer st = new StringTokenizer(str, " ");
        String command = st.nextToken();
        if(command.equals("push")){
            queue.add(Integer.parseInt(st.nextToken()));
        }
        else if(command.equals("pop")){
            if(queue.isEmpty()){
                System.out.println("-1");
            }
            else {
                System.out.println(queue.poll());
            }
        }
        else if(command.equals("size")){
            System.out.println(queue.size());
        }
        else if(command.equals("empty")){
            if(queue.isEmpty()){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
        else if(command.equals("front")){
            if(queue.isEmpty()){
                System.out.println("-1");
            }
            else{
                System.out.println(queue.peek());
            }
        }
        else if(command.equals("back")){
            if(queue.isEmpty()){
                System.out.println("-1");
            }
            else{
                System.out.println(queue.getLast());
            }
        }
    }
}