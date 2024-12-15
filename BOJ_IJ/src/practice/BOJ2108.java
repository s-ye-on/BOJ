package practice;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;


// 2108
public class BOJ2108 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(findAverage(arr));
        System.out.println(findMiddle(arr));
        System.out.println(findMode(arr));
        System.out.println(findArrange(arr));

    }
    static int findAverage(int[] arr){
        double sum =0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return (int) Math.round(sum/arr.length);
    }
    static int findMiddle(int[] arr){
        Arrays.sort(arr);
        int middleNumber = arr.length/2;
        return arr[middleNumber];
    }
    static int findMode(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        if(arr.length ==1){
            return arr[0];
        }
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        int maxValue = Collections.max(map.values());
        ArrayList<Integer> arrayList = new ArrayList<>();
        // Map.Entry 객체 컬렉션으로 Map.Entry의 하나 개의 클래스 저장 키와 값 함께 가져옴
        // Map.Entry : map 의 collection-view 를 return
        // entrySet() : 해당 map에 담겨 있는 key와 value의 연결들(mappings)을 반환
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==maxValue){
                arrayList.add(entry.getKey());
            }
        }
        Collections.sort(arrayList);
        if(arrayList.size() >1){
            return arrayList.get(1);
        }
        else{
            return arrayList.get(0);
        }
    }
    static int findArrange(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1] - arr[0];
    }
}