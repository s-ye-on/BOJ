        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.nio.Buffer;
        import java.util.HashSet;
        import java.util.StringTokenizer;
        import java.io.IOException;
        import java.util.Comparator;
        import java.util.Stack;
        import java.util.Collections;
        import java.util.ArrayList;
        public class temp {
            public static void main(String[] args) throws IOException{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;
                String str = br.readLine();
                st = new StringTokenizer(str);
                int N = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                StringBuilder sb = new StringBuilder();

                while(N>0){
                    int remain = N%B;

                    if(remain >9){
                        sb.append((char)(remain -10 +'A'));
                    }
                    else{
                        sb.append(remain);
                    }
                    N /=B;
                }
                sb.reverse();
                System.out.println(sb);

                System.out.println((int)'A');
            }
        }