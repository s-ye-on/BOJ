    package ch01;

    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.BufferedReader;
    import java.util.*;

    public class Main {
        public static void main(String args[])throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st;
            HashMap<String, String> map = new HashMap<String, String>();

            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++){
                String str = br.readLine();
                st = new StringTokenizer(str," ");
                String name = st.nextToken();
                String io = st.nextToken();

                if(map.containsKey(name)){
                    map.remove(name);
                }
                else {
                    map.put(name, io);
                }
            }
            ArrayList<String> list = new ArrayList<String>(map.keySet());
            Collections.sort(list, Collections.reverseOrder());

            for(var li : list){
                System.out.println(li +" ");
            }
        }
    }