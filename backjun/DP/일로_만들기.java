package DP;

import java.io.*;

public class 일로_만들기 {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;
        System.out.println(dp(N));
        System.out.println(dp2(N));
    }

    // Top-Down 방식 => 메모리 : 79952KB / 시간 : 228ms
    public static int dp(int N) {

        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(dp(N / 3), Math.min(dp(N / 2), dp(N - 1))) + 1;
            }
            else if (N % 3 == 0) {
                dp[N] = Math.min(dp(N / 3), dp(N - 1)) + 1;
            }
            else if (N % 2 == 0) {
                dp[N] = Math.min(dp(N / 2), dp(N - 1)) + 1;
            }
            else {
                dp[N] = dp(N - 1) + 1;
            }
        }

        return dp[N];

    }

    // Bottom-Up 방식 => 메모리 : 15476KB / 시간 : 96ms
    public static int dp2(int N) {

        int[] dp = new int[N+1];
        for (int i = 2; i <= N; i++) {

            // 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지는 경우
            if ( i % 2 == 0 ) dp[i] = Math.min(dp[i], dp[i / 2] + 1);

            // 3으로 나누어 떨어지는 경우
            if ( i % 3 == 0 ) dp[i] = Math.min(dp[i], dp[i / 3] + 1);

        }

        return dp[N];
    }
}
