package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 복잡도 : O(N)
 */
public class 연속합 {

    static int N;
    static int[] dp;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        array = new int[N+1];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        dp[1] = array[1];
        for (int i = 2; i < N+1; i++) { // O(N)
            dp[i] = Math.max(array[i], dp[i-1] + array[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N+1; i++) { // O(N)
            max = Math.max(max, dp[i]);
        }

        System.out.print(max);
    }

}
