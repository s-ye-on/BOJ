    import javax.management.StringValueExp;
    import java.io.BufferedReader;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.util.Scanner;
    import java.io.IOException;
    import java.util.Comparator;
    import java.util.StringTokenizer;
    import java.util.Arrays;
    import java.math.BigInteger;
    import java.util.HashSet;
    import java.util.Deque;
    import java.util.Queue;
    import java.util.LinkedList;
    import java.util.Stack;
    import java.util.Iterator;

    public class Main {
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            String str = br.readLine();
            HashSet<Integer> hashset = new HashSet<>();

            StringTokenizer st = new StringTokenizer(str," ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());


            for(int i=1; i<=N; i++){
                int out = N/i;
                if(N%i==0){
                    hashset.add(out);
                }
            }
            int [] arr = new int[hashset.size()];
            Iterator iter = hashset.iterator();
            if(hashset.size()<K){
                System.out.println(0);
            }
            else{
                int next=0;
                for(int i=0; i<K; i++){
                    next =(int) iter.next();
                }
                System.out.println(next);
            }
        }
    }

