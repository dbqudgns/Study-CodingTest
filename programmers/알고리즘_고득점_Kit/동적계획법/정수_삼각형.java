package 알고리즘_고득점_Kit.동적계획법;

import java.util.*;

// DP : 바텀업 방식 적용
public class 정수_삼각형 {

    public static int solution(int[][] triangle) {

        int height = triangle.length; // 삼각형의 높이
        int[][] dp = new int[height][height]; // DP 배열 => 각 위치에서 만들 수 있는 최대값 저장

        // 1. DP 배열의 마지막 줄 초기화
        // 삼각형의 가장 아래 줄은 더 내려갈 곳이 없으므로 그 값 자체가 최댓값이 된다.
        for (int i = 0; i < height; i++) {
            dp[height-1][i] = triangle[height-1][i];
        }

        // 2. 두 번째 줄부터 거꾸로 올라가며 최대값을 채워 넣는다 -> 바텀업 방식
        /**
         * 각 위치 (i, j)에서 선택할 수 있는 경로는 아래쪽 두 칸 :
         *   - 왼쪽 아래 (i+1, j)
         *   - 오른쪽 아래 (i+1, j+1)
         * 두 경로 중 더 큰 값을 선택해서 현재 값과 더해준다.
         */
        for (int i = height - 2; i >= 0; i--) { // 아래에서 두 번째 줄 부터 시작
            for (int j = 0; j <= i; j++) { // 현재 줄의 모든 원소애 대해 왼쪽 아래 or 오른쪽 아래 중 큰 값과 현재 위치의 값을 더한다.
                dp[i][j] = triangle[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        // 3. 맨 꼭대기(dp[0][0])에 최대값이 저장된다.
        return dp[0][0];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int[][] triangle = new int[height][];

        for (int i = 0; i < height; i++) {
            triangle[i] = new int[i+1];
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(triangle));
    }

}
