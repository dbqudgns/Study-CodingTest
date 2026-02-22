package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 제곱수의_합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        /** 나의 틀린 코드
        int value = 1;
        for (int i = 1; i < N + 1; i++) {
             if (i == value * value) {
                 dp[i] = 1;
                 value++;
             }
        }

        value = 0; // 문제점 : value가 i랑 가장 가까운 제곱근일 때 기준으로 최소 항을 구하고 있다.
                   //         i랑 가장 가까운 제곱근이 아닌 다른 제곱근으로 최소 항을 구할 수 있다.
        for (int i = 1; i < N + 1; i++) {
            if (dp[i] != 1) {
                dp[i] = dp[i - (value * value)] + 1;
            }
        } */

        for (int i = 1; i < N + 1; i++) {

            dp[i] = Integer.MAX_VALUE;

            for (int j = 1; j <= i; j++) {
                if (j * j <= i) {
                    int num = dp[i - (j * j)] + 1;
                    dp[i] = Math.min(dp[i], num);
                }
                else break;
            }

        }

        System.out.print(dp[N]);
    }
}