package boj.boj1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
class Node{
    int to;
    int cost;
    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
/*
    트리의 지름 문제
    dfs두번 사용 첫사용 때 가장 먼 노드 찾고 두번째 사용 때 그 노드에서부터 가장 먼 노드 찾기
    sum 매개 변수 하나 두고 가중치 다 더해줌
    if문으로 가장 먼 거리 저장
    가장 먼 노드도 전역변수로 저장했다가 사용
    트리는 visited 확인 안하면 무한 루프에 빠질 수 있으니 visited 사용
 */
public class BOJ1167 {
    public static int nodeCount;
    public static List<Node>[] tree;
    public static boolean[] visited;
    public static int maxDistance;
    public static int farthestNode;
    public static void dfs(int current, int sum){
        visited[current] = true;
        if(sum >= maxDistance) {
            maxDistance = sum;
            farthestNode = current;
        }
        for(Node node : tree[current]) {
            if(!visited[node.to]) {
                dfs(node.to, sum + node.cost);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeCount = Integer.parseInt(br.readLine());
        visited = new boolean[nodeCount+1];
        tree = new List[nodeCount+1];
        for(int i=0; i<=nodeCount; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<nodeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while(true){
                String token =st.nextToken();
                if(token.equals("-1")) break;
                int to = Integer.parseInt(token);
                int cost = Integer.parseInt(st.nextToken());
                tree[start].add(new Node(to, cost));
            }
        }
        dfs(1,0);
        int newStart = farthestNode;
        Arrays.fill(visited, false);
        farthestNode = 0;
        maxDistance = 0;
        dfs(newStart, 0);
        System.out.println(maxDistance);
    }
}
