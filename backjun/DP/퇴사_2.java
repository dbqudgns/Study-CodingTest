package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] period = new int[N + 2];
        int[] money = new int[N + 2];
        StringTokenizer token;
        for (int i = 1; i < N + 1; i++) {
            token = new StringTokenizer(br.readLine());
            period[i] = Integer.parseInt(token.nextToken());
            money[i] = Integer.parseInt(token.nextToken());
        }

        int dp[] = new int[N + 2];
        for (int i = 1; i < N + 1; i++) {

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            if (i + period[i] <= N + 1)
                dp[i + period[i]] = Math.max(dp[i + period[i]], dp[i] + money[i]);
        }

        System.out.println(dp[N + 1]);
    }
}