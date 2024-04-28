package ch04;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class practice {
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        int sum=0;
        for(int i=0; i<K; i++){
            int num = Integer.parseInt(br.readLine());
            solve(num);
        }
        for(int i=0; i<stack.size(); i++){
            sum += stack.elementAt(i);
        }
        System.out.println(sum);

    }
    public static void solve(int num){
        if(num == 0){
            stack.pop();
        }
        else{
            stack.push(num);
        }
    }
}
