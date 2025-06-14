package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Person{
    int age;
    String name;

    Person(int age, String name){
        this.age = age;
        this.name = name;
    }
}
public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people[i] = new Person(age, name);
        }
        Arrays.sort(people, Comparator.comparingInt(p -> p.age));
        // 내림차순 정렬하고 싶은 경우에는
        // Arrays.sort(people, Comparator.comparingInt(p -> p.age)).reversed();
        // Arrays.sort(people, (o1, o2) -> o1.age - o2.age);
        /*
        자바의 Comparator
        정렬 기준을 커스텀하고 싶을 때 사용하는 인터페이스
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age; // 오름차순
                return o2.age - o1.age; // 내림차순

               // 정말 이해가 안됐었던 부분이 있었음
               o1 - o2 던 o2 - o1이던 계산 값이 음수가 나오면 o1이 앞으로가고, 양수가 나오면 o2가 앞으로 온다
               -> o1 - o2 는 결국 오름차순
               -> o2 - o1은 결국 내림차순이 됨
                }
            });
            또는 람다식으로 표현할 경우
            Arrays.sort(people, (o1, o2) -> o1.age - o2.age);
         */
        /*
        자바의 Arrays.sort()는 기본적으로 stable sort라서
        같은 나이일 때 입력된 순서대로 유지해줌
        stable sort : 정렬을 할 때, 같은 요소들끼리 원래 있던 순서를 유지하는 정렬 방식
         */
        for(Person p : people) {
            System.out.println(p.age + " " + p.name);
        }
    }
}
