package 알고리즘_고득점_Kit.동적계획법;

import java.util.*;

public class 사칙연산 {

    public static int solution(String arr[]) {

        int n = arr.length / 2 + 1; // 숫자의 개수 : 전체 길이 / 2 + 1
        int[][] dpMax = new int[n][n]; // dpMax[i][j] : i번째 숫자부터 j번째 숫자까지 최댓값
        int[][] dpMin = new int[n][n]; // dpMin[i][j] : i번째 숫자부터 j번째 숫자까지 최솟값

        // 1. 숫자 초기화 -> 자기 자신을 고려한 경우 : ex. 0번째 숫자부터 0번째 숫자까지 최댓값/최소값
        for (int i = 0; i < n; i++) {
            dpMax[i][i] = Integer.parseInt(arr[i * 2]); // i번째 숫자
            dpMin[i][i] = Integer.parseInt(arr[i * 2]); // i번째 숫자
        }

        // 2. 구간 길이를 1부터 시작해서 점차 늘려가며 모든 경우 탐색
        /**
         * len : 구간의 길이
         * i : 구간의 시작 인덱스 (왼쪽 숫자의 위치)
         * j : 구간의 끝 인덱스 (오른쪽 숫자의 위치)
         * k : 구간 [i, j] 안에서 나눌 기준 -> 연산자 위치
         */
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len; // 구간의 끝 인덱스
                dpMax[i][j] = Integer.MIN_VALUE; // 최댓값 초기화
                dpMin[i][j] = Integer.MAX_VALUE; // 최솟값 초기화

                // 3. i ~ j 구간을 k 기준으로 나누어 계산
                for (int k = i; k < j; k++) {
                    String operator = arr[k * 2 + 1]; // k번째 연산자 ( + 또는 - )
                    int maxLeft = dpMax[i][k]; // 왼쪽 구간 최대값
                    int minLeft = dpMin[i][k]; // 왼쪽 구간 최솟값
                    int maxRight = dpMax[k + 1][j]; // 오른쪽 구간 최댓값
                    int minRight = dpMin[k + 1][j]; // 오른쪽 구간 최솟값

                    // 4. 연산자에 따라 최댓값/최솟갑 갱신
                    if (operator.equals("+")) {
                        // +는 단순히 합이므로 (최대+최대, 최소+최소)
                        dpMax[i][j] = Math.max(dpMax[i][j], maxLeft + maxRight);
                        dpMin[i][j] = Math.min(dpMin[i][j], minLeft + minRight);
                    }
                    else if (operator.equals("-")) {
                        // -는 순서에 따라 값이 달라지므로
                        // 최댓값 = 왼쪽 최댓값 - 오른쪽 최솟값
                        dpMax[i][j] = Math.max(dpMax[i][j], maxLeft - minRight);
                        // 최솟값 = 왼쪽 최솟값 - 오른쪽 최댓값
                        dpMin[i][j] = Math.min(dpMin[i][j], minLeft - maxRight);
                    }
                }
            }
        }
        return dpMax[0][n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String[] arr = new String[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.next();
        }

        System.out.println(solution(arr));
    }

}
