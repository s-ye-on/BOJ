package ch04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Real_Question04_2 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputData = br.readLine();
        int row = inputData.charAt(1) -'0';
        int column = inputData.charAt(0)-'a'+1;

        int [] dx ={-2,-1,1,2,2,1,-1,-2};
        int [] dy ={-1,-2,-2,-1,1,2,2,1};

        int result =0;
        for(int i=0; i<8; i++){
            int nextRow = row +dx[i];
            int nextColumn = column + dy[i];
            if(nextRow >=1 && nextRow<=8 &&nextColumn>=1 && nextColumn<=8){
                result++;
            }
        }
        System.out.println(result);
    }
}
