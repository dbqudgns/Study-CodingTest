package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드_구매하기 {

    static int N;
    static int[] dp;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token;
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        input = new int[N + 1];

        token = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            input[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 1; i < N+1; i++) { // 바텀업 방식 진행
            for (int j = 1; j < N+1; j++) { // j개의 카드 팩을 골랐다고 가정
                int k = i - j; // k : j개의 카드 팩을 고른 후 골라야 하는 나머지 카드 개수
                if (k >= 0) {
                    dp[i] = Math.max(dp[i], input[j] + dp[k]);
                }
            }
        }

        System.out.print(dp[N]);
    }
}