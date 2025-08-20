package 알고리즘_고득점_Kit.동적계획법;

import java.util.*;

public class 등굣길 {

    public static int solution(int m, int n, int[][] puddles) {

        // dp[i][j] = (i, j)까지 도달하는 최단경로의 개수
        // 1. n행, m열 크기의 DP 테이블 선언
        int[][] dp = new int[n][m];

        // 2. 물에 잠긴 지역을 -1로 표시
        // puddles의 좌표는 (x, y) 형식인데 배열은 [y-1][x-1]로 접근해야 한다. -> 배열은 0부터 시작하기 때문에
        for (int[] location : puddles) {
            dp[location[1] - 1][location[0] - 1] = -1;
        }

        // 3. 시작 위치(집)에는 1가지 경로가 존재 -> 출발 자체가 1가지 방법이다.
        dp[0][0] = 1;

        // 4. DP 테이블 채우기
        for (int i = 0; i < n; i++) { // 행 순회
            for (int j = 0; j < m; j++) { // 열 순회

                // 시작점이거나 물웅덩이인 경우는 건너뛰기
                if ((i == 0 && j == 0) || dp[i][j] == -1) continue;

                // 위쪽에서 내려오는 경우
                // 현재 위치의 위쪽에서 내려올 수 있으면 그 경로 수를 가져오고 불가능하면 0으로 처리한다.
                int top = (i == 0 || dp[i - 1][j] == -1) ? 0 : dp[i - 1][j];

                // 왼쪽에서 오는 경우
                // 현재 위치의 왼쪽에서 올 수 있으면 그 경로 수를 가져오고 불가능하면 0으로 처리한다.
                int left = (j == 0 || dp[i][j - 1] == -1) ? 0 : dp[i][j - 1];

                // 현재 위치까지의 경로 수 = 위쪽 경로 수 + 왼쪽 경로 수
                dp[i][j] = (top + left) % 1000000007; // 문제 조건에 따라 모듈러 연산 수행

            }
        }

        // 5. 도착점(학교)에 도달하는 최단 경로 개수를 반환
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int size = sc.nextInt();
        int[][] puddles = new int[size][2];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                puddles[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(m, n, puddles));
    }

}
