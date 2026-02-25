package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기 {

    /**
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] dp = new int[size];

        int[] stair = new int[size];
        for (int i = 0; i < size; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        int index = size - 1; // 5
        dp[index] = stair[index]; // dp[5] = 20

        while (index > 0) { // index:5 통과, index:3 통과, index:1 통과

            // -1 언더
            int minusOne = 0;
            if (index - 1 >= 0) {
                minusOne = dp[index] + stair[index - 1]; // minusOne = 65 + 10 = 75
            }

            // -2 언더
            int minusTwo = 0;
            if (index - 2 >= 0) {
                minusTwo = dp[index] + stair[index - 2]; // minusTwo = 0
            }

            if (minusOne == 0 && minusTwo == 0) break;

            // 두 합 중 제일 큰 수를 고른다.
            int chooseBigOne = Math.max(minusOne, minusTwo); // chooseBigOne = 75

            // 제일 큰 수의 인덱스를 찾는다.
            if (chooseBigOne == minusOne) {
                index = index - 1;
            }
            else {
                index = index - 2;
            }

            // index : 0

            // 해당 인덱스에 누적 합을 넣은다.
            dp[index] = chooseBigOne; // dp[0] = 65
        }

        System.out.println(dp[index]);
    } **/

    static Integer[] dp;
    static int[] stair;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        dp = new Integer[size];

        stair = new int[size];
        for (int i = 0; i < size; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(find(size - 1));
    }

    // TopDown : 메모이제이션 + 재귀 사용
    public static int find(int n) {
        if (n < 0) return 0;

        if (dp[n] == null) { // 시간 초과 방지용 (없으면 dp[n] 배열 중복 계산이 일어남)
            if (n == 0) {
                dp[0] = stair[0];
            } else if (n == 1) {
                dp[1] = stair[0] + stair[1];
            } else {
                dp[n] = Math.max(find(n - 2), find(n - 3) + stair[n - 1]) + stair[n];
            }
        }

        return dp[n];
    }
}