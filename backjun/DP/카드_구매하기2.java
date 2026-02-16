package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드_구매하기2 {

    static int N;
    static int[] input;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = new int[N+1];
        dp = new int[N+1];

        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            input[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.fill(dp, Integer.MAX_VALUE);


        dp[0] = 0;
        for (int i = 1; i < N+1; i++) { // BottomUp : 1 ~ N개를 뽑았을 때
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], input[j] + dp[i - j]);
            }
        }

        System.out.println(dp[N]);
    }
}
