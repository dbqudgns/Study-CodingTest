package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주_시식 {

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        int[] array = new int[n];
//        int[] dp = new int[n]; // 현재 i번째 포도주의 최대 누적합
//
//        for (int i = 0; i < n; i++) {
//            array[i] = Integer.parseInt(br.readLine());
//        }
//
//        if(n == 1) {
//            System.out.print(array[0]);
//            return;
//        } else if (n == 2) {
//            System.out.print(array[0] + array[1]);
//            return;
//        } else if (n == 3) {
//            int answer = Math.max(array[0] + array[1], Math.max(array[1] + array[2], array[0] + array[2]));
//            System.out.print(answer);
//            return;
//        }
//
//        dp[0] = array[0];
//        dp[1] = array[0] + array[1];
//        dp[2] = Math.max(array[0] + array[1], Math.max(array[1] + array[2], array[0] + array[2]));
//
//        for (int i = 3; i < n; i++) {
//            dp[i] = Math.max(dp[i - 1], // 현재 포도주를 건너뛰는 경우
//                    Math.max(array[i] + dp[i - 2], // 이번 포도주는 마시지만, 이전 포도주는 건너뛰는 경우
//                            array[i - 1] + array[i] + dp[i - 3])); // 이번 포도주와 이전 포도주도 마시는 경우
//        }
//
//
//        System.out.print(dp[n-1]);
//    }

        // 최적화 코드
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[10001];
        int[] dp = new int[10001]; // 현재 i번째 포도주의 최대 누적합

        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = array[1];
        dp[2] = array[1] + array[2]; // n=1이어도 array[2]는 기본 값이 0이므로 상관 없음

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], // 현재 포도주를 건너뛰는 경우
                    Math.max(array[i] + dp[i - 2], // 이번 포도주는 마시지만, 이전 포도주는 건너뛰는 경우
                            array[i - 1] + array[i] + dp[i - 3])); // 이번 포도주와 이전 포도주도 마시는 경우
        }

        System.out.print(dp[n]);
    }
}