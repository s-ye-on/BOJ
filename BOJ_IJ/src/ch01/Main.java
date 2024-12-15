    package ch01;

    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.BufferedReader;
    import java.util.*;
    import java.util.function.BiFunction;

    public class Main {
        public static void main(String [] args)throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());

            // 애초에 정렬까지 되는 트리셋으로 가자
            Set<String> set = new TreeSet<>((a,b) -> {
                if(a.length() != b.length()){
                    return Integer.compare(a.length(), b.length()); //길이순
                }
                else{
                    return a.compareTo(b); // 사전순 compareTo() 메서드는 기본내장 메서드
                    // 사전순으로 정렬해주는 기능을 함
                }
            });
            for(int i=0; i<N; i++) {
                set.add(br.readLine());
            }
            for(String s : set) {
                System.out.println(s);
            }
        }
    }