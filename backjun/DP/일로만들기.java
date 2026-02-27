package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[1] = 0;
        for (int i = 2; i < N + 1; i++) {

            int minusOne = dp[i-1] + 1;

            int divideTwo = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                divideTwo = dp[i / 2] + 1;
            }

            int divideThree = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                divideThree = dp[i / 3] + 1;
            }

            dp[i] = Math.min(minusOne, Math.min(divideTwo, divideThree));
        }

        System.out.print(dp[N]);
    }
}