package algorithm.baekjoon.dp;

import java.io.*;

public class MakeIt1_1463 {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bf.readLine());

        dp = new Integer[x+1];
        dp[0] = dp[1] = 0;

        System.out.println(calculation(x));
    }

    static int calculation(int n) {

        if(dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(calculation(n-1), Math.min(calculation(n/3), calculation(n/2))) + 1;
            } else if(n % 3 == 0) {
                dp[n] = Math.min(calculation(n / 3), calculation(n - 1)) + 1;
            } else if(n % 2 == 0) {
                dp[n] = Math.min(calculation(n / 2), calculation(n - 1)) + 1;
            } else {
                dp[n] = calculation(n - 1) + 1;
            }
        }

        return dp[n];
    }
}
