package DP;

import java.io.*;

public class 일23더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] nArray = new int[T];
        for (int i = 0; i < T; i++) {
            nArray[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for (int i = 0; i < T; i++) {
            int num = nArray[i];
            System.out.println(dp[num]);
        }
    }
}