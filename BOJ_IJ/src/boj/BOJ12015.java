package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=1; i<N; i++) {
            if(arr[i] > list.get(list.size()-1)) {
                list.add(arr[i]);
            }
            else{// 최대값보다 작은 경우 이 값으로 큰 수들을 대체해 줄 수 있는지 봄
                int index = Collections.binarySearch(list, arr[i]); // list에서 num이 들어갈 위치 찾기 -> 이 부분에서 이분 탐색 사용했음
                if(index < 0) { //리스트에서 arr[i]와 같은 값을 찾지 못한 경우 -> -(삽입할 위치) -1 반환 함
                    index = -(index+1); //삽입할 위치
                    list.set(index, arr[i]); // 값 대체 -> list는 반환 수열이 아니라 수열의 그 자리에 들어갈 수 있는 최솟값의 집합
                    // 각 자리에 들어갈 수 있는 가장 작은 수들로 이루어진 배열
                    // -> 최장 증가 수열이 list의 값이라는것을 보장하지 않음! list의 길이가 되는 LIS가 존재한다는 사실만 알려줌
                }
            }
        }
        System.out.println(list.size());
    }
}
