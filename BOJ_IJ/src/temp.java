        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.StringTokenizer;

        /*
        추가 보완할 점
        1. Point 클래스 생성, 좌표명시형 자료구조 연습
        2. (옵션) 방문배열, 방향 배열 구조화
        사실 방문배열은 이 문제에서는 필요 없지만 원본 배열 저장을 위해 구현하는 것임
        큐에 Point를 넣으니, 방향 배열 dx, dy도 Point로 만들 수 있음
         */
        public class temp {
            public static int N, M;
            public static int[] dx = {-1, 1, 0, 0};
            public static int[] dy = {0, 0, -1, 1};
            public static int[][] map;
            public static int bfs(int y, int x){
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{y, x});
                while(!queue.isEmpty()){
                    int[] arr = queue.poll();
                    int curY = arr[0];
                    int curX = arr[1];
                    for(int i=0; i<4; i++){
                        int newY = curY + dy[i];
                        int newX = curX + dx[i];
                        if(newX>=0 && newX<M && newY>=0 && newY<N && map[newY][newX]==1){
                            map[newY][newX] = map[curY][curX] + 1;
                            queue.offer(new int[]{newY, newX});
                        }
                    }
                }
                return map[N-1][M-1];
            }

            public static void main(String[] args) throws IOException{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken()); //세로
                M = Integer.parseInt(st.nextToken()); //가로
                map = new int[N][M];

                for(int i=0; i<N; i++){
                    String line = br.readLine();
                    for(int j=0; j<M; j++){
                        map[i][j] = line.charAt(j)-'0';
                    }
                }
                int result = bfs(0, 0);
                System.out.println(result);
            }
        }