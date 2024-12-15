package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.math.BigInteger;

public class BOJ1010 {
    public static void main(String [] args)throws IOException {
        // mCn
        // m!/n!(m-n)!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            long N = Integer.parseInt(input[0]);
            long M = Integer.parseInt(input[1]);

            long L = M-N;

            BigInteger factorialN = factorial(BigInteger.valueOf(N));
            BigInteger factorialM = factorial(BigInteger.valueOf(M));
            BigInteger factorialL = factorial(BigInteger.valueOf(L));

            BigInteger result = factorialM.divide(factorialN.multiply(factorialL));

            System.out.println(result);
        }
    }
    public static BigInteger factorial(BigInteger n) {
        if(n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)){
            return BigInteger.ONE;
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
        /*
        덧셈 .add
        뺄셈 .subtract
        곱셈 .multiply
        나눗셈 .divide
        나머지 .remainder
         */
}