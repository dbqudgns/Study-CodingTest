package DP;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.*;

public class 퇴사2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] : i번째 날부터 퇴사일까지 벌 수 있는 최대 수익
        // N+2인 이유는 i + T[i]가 N+1이 되는 경우(마지막 날 끝나는 경우)를 대비
        int[] dp = new int[N + 2];

        // 뒤에서부터 거꾸로 계산 (N일부터 1일까지)
        for (int i = N; i >= 1; i--) {
            int nextDay = i + T[i]; // 상담이 끝나는 다음 날

            if (nextDay <= N + 1) {
                // 상담을 할 수 있는 경우 :
                // max(오늘 상담 안 하기(내일 수익 그대로), 오늘 상담 하기(오늘 수익 + 상담 끝난 후 수익))
                dp[i] = Math.max(dp[i + 1], P[i] + dp[nextDay]);
            } else {
                // 상담을 할 수 없는 경우 (퇴사일 넘김) :
                // 그냥 내일의 수익을 그대로 가져옴
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);

    }
}