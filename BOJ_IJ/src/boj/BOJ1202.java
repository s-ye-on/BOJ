package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Jewel implements Comparable<Jewel> {
    int weight , value;
    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
    @Override
    public int compareTo(Jewel o) {
        return this.weight - o.weight; // 무게 기준 오름차순 정렬
    }
}
public class BOJ1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석 수
        int K = Integer.parseInt(st.nextToken()); // 가방 수

        List<Jewel> jewels = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(weight, value));
        }
        int[] bags = new int[K];
        for(int i=0; i<K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Collections.sort(jewels);
        Arrays.sort(bags);
        // 람다 사용해서 무게 기준으로 pq에 들어가지 않고, 가치 기준 내림차순으로 들어가게 조정
        PriorityQueue<Jewel> pq = new PriorityQueue<>((o1,o2)->o2.value - o1.value);
        long totalValue = 0;
        int index = 0;

        for(int bag : bags) {
            while(index < N && jewels.get(index).weight <= bag){
                // 익명 클래스 방법 -> 클래스 선언 + 인스턴스 생성 동시에
                // 해당 익명 클래스 안에서만 오버라이딩 적용 (해당 익명 클래스 인스턴스만 다르게 동작)
                // 해당 객체 한정 변경. 원래 클래스는 영향받지 않음
                // 익명 클래스는 끝에 반드시 콜론(;)을 붙여주어야한다
                pq.offer(jewels.get(index));
                index++;
                }
            if(!pq.isEmpty()) {
                totalValue += pq.poll().value;
            }
        }
        System.out.println(totalValue);
    }
}
