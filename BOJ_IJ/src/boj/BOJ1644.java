package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /*
        에라토스테네스의 체
        O(N * log log N)
        2부터 N까지 숫자 중에서 소수가 아닌 수를 지워나가고 소수만 남기는 방법
        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = isNotPrime[1] = true;  // 0, 1은 소수가 아니야!

        for (int i = 2; i * i <= N; i++) { -> 어떤 수 N의 약수는 항상 √N보다 작거나 같은 수에 하나는 꼭 존재하기에 거기까지만 확인해도 충분
            if (!isNotPrime[i]) { // i가 소수일 때
                for (int j = i * i; j <= N; j += i) { -> i의 배수들을 하나씩 지워가는 로직 i*i부터 시작하는 이유는 그 보다 작은 배수들은 이미 이전의 작은 소수에서 지워짐
                    isNotPrime[j] = true; i의 배수들은 소수가 아님
                }
            }
        }
        소수인 수들 리스트에 추가
        List<Integer> primes = new ArrayList<>();
        for(int i=2; i<= N; i++){
            if(!isNotPrime[i]){
                primes.add(i);
                }
            }
         */
        List<Integer> primes = new ArrayList<>();
        boolean [] isNotPrime = new boolean[N+1];
        isNotPrime[0] = isNotPrime[1] = true;
        //소수만 남김
        for(int i=2; i*i <= N; i++) {
            if(!isNotPrime[i]) {
                for(int j = i*i; j <= N; j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }
        //남은거 리스트에 추가
        for(int i = 2; i <= N; i++) {
            if(!isNotPrime[i]) {
                primes.add(i);
            }
        }
        int left =0, right =0;
        int count =0;
        int sum = 0;
        while(true){
            if(sum >= N) sum -= primes.get(left++);
            else if(right == primes.size()) break;
            else sum += primes.get(right++);
            if(sum == N) count++;
        }
        System.out.println(count);
    }
}
