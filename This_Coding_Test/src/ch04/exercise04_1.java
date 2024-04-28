package ch04;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Scanner;

//page110
//상하좌우
public class exercise04_1 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int x=1;
        int y=1;
        char [] move_type = {'L','R','U','D'};
        int [] dx = {0,0,-1,1};
        int [] dy = {-1,1,0,0};
        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            char plan = str.charAt(i);
            int nx = -1;
            int ny = -1;
            for(int j=0; j<4; j++){
                if(move_type[j] == plan){
                    nx = dx[j] + x;
                    ny = dy[j] + y;
                }
            }
            if(nx<1 || ny<1 || nx>N || ny>N){
                continue;
            }
            x = nx;
            y = ny;
        }
        System.out.println(x+" "+y);
    }
}
