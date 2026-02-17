package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일23더하기5 {

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        dp = new long[100001][4];
        dp[1][1] = 1; dp[1][2] = 0; dp[1][3] = 0;
        dp[2][1] = 0; dp[2][2] = 1; dp[2][3] = 0;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        for (int index = 4; index <= 100000; index++) {
            dp[index][1] = (dp[index-1][2] + dp[index-1][3]) % 1000000009;
            dp[index][2] = (dp[index-2][1] + dp[index-2][3]) % 1000000009;
            dp[index][3] = (dp[index-3][1] + dp[index-3][2]) % 1000000009;
        }

        StringBuilder sb = new StringBuilder();
        for (int index = 1; index <= tc; index++) {
            int num = Integer.parseInt(br.readLine());

            long sum = 0;
            for (int i = 1; i < 4; i++) {
                sum += dp[num][i];
            }
            sum %= 1000000009;

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}