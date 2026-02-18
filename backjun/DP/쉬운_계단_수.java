package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운_계단_수 {

    static long[][] dp; // 길이가 n일 때, 마지막 숫자가 j인 계단 수의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new long[N+1][10];
        dp[1][0] = 0; dp[1][1] = 1; dp[1][2] = 1;
        dp[1][3] = 1; dp[1][4] = 1; dp[1][5] = 1;
        dp[1][6] = 1; dp[1][7] = 1; dp[1][8] = 1; dp[1][9] = 1;

        for (int i = 2; i <= N; i++) {

            // 맨 뒷자리가 0인 경우는 앞 자리가 1인 경우이다.
            dp[i][0] = dp[i-1][1] % 1000000000;

            // 맨 뒷자리가 9인 경우는 앞 자리가 8인 경우이다.
            dp[i][9] = dp[i-1][8] % 1000000000;

            // 맨 뒷자리가 1~8인 경우는 앞 자리가 -1, +1인 경우이다.
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
        }
        sum %= 1000000000;

        System.out.println(sum);
    }
}