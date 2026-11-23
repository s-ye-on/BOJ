package boj.boj1967;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    문제 카테고리가 dfs였는데, 문제 읽어보니 다익스트라로 풀어도 되지 않을까 생각이듬
    다익스트라로 풀어도 되지만 트리는 사이클이 없고, 노드 수가 적어서 다익스트라보다 dfs 2번으로 푸는게 빠르고 간결
    일반 그래프라면 다익스트라도 괜찮지만 이 문제는 트리임
    트리의 지름 구하는 방법 (DFS 2번)
    1. 임의의 노드(보통 1번)에서 dfs 시작 -> 그떄 가장 멀리 있는 노드 A 찾음
    2. 그 노드 A를 시작점으로 다시 DFS -> 이번엔 가장 먼 노드 B를 찾음
    그때의 거리가 트리의 지름이 됨
 */
class Node{
    int to;
    int weight;
    Node(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
}
public class BOJ1967 {
    public static ArrayList<Node>[] tree;
    public static boolean[] visited;
    public static int maxDistance =0;
    public static int farthestNode =0;
    public static void dfs(int current, int sum){
        visited[current] = true; // 방문 체크
        if(sum > maxDistance){
            maxDistance = sum;
            farthestNode = current;
        }
        for(Node next : tree[current]){
            if(!visited[next.to]){
                dfs(next.to, sum+next.weight);
            }
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        if(nodeCount == 1){
            System.out.println(0);
            return;
        }
        tree = new ArrayList[nodeCount+1];
        visited = new boolean[nodeCount+1];

        for(int i=0; i<=nodeCount; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=0; i<nodeCount-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[from].add(new Node(to, weight));
            tree[to].add(new Node(from, weight));
        }
        dfs(1,0);
        // farthestNode 에 A가 담김
        int startNode = farthestNode;
        //초기화하고 2차 dfs
        Arrays.fill(visited, false);
        maxDistance = 0;
        farthestNode = 0;
        dfs(startNode,0);
        System.out.println(maxDistance);
    }
}
