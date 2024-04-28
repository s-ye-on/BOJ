import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJP {
    public static void main (String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double sum =0;
        double creditSum =0;
        String str;

        while(true){
            str= br.readLine();
            if(str == null) break;
            st = new StringTokenizer(str);

            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if(!grade.equals("P")){
                double score = checkGrade(grade);

                creditSum +=credit;
                sum += credit * score;
            }
        }
        double avg = sum / creditSum;
        System.out.println(avg);

    }


    public static double checkGrade(String grade){
        if(grade.startsWith("A")){
            if(grade.equals("A0")) return 4.0;
            else return 4.5;
        }
        else if(grade.startsWith("B")){
            if(grade.equals("B0")) return 3.0;
            else return 3.5;
        }
        else if(grade.startsWith("C")){
            if(grade.equals("C0")) return 2.0;
            else return 2.5;
        }
        else if(grade.startsWith("D")){
            if(grade.equals("D0")) return 1.0;
            else return 1.5;
        }
        else{
            return 0;
        }
    }
    public static int checkNum(char num) {
        //2
        if (num == 'A' || num == 'B' || num == 'C') return 2;
            //3
        else if (num == 'D' || num == 'E' || num == 'F') return 3;
            //4
        else if (num == 'G' || num == 'H' || num == 'I') return 4;
            //5
        else if (num == 'J' || num == 'K' || num == 'L') return 5;
            //6
        else if (num == 'M' || num == 'N' || num == 'O') return 6;
            //7
        else if (num == 'P' || num == 'Q' || num == 'R' || num =='S') return 7;
            //8
        else if (num == 'T' || num == 'U' || num == 'V') return 8;
            //9
        else if (num == 'W' || num == 'X' || num == 'Y' || num =='Z') return 9;
        else return 0;
    }
}
