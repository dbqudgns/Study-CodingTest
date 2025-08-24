package 알고리즘_고득점_Kit.동적계획법;

import java.util.*;

public class 도둑질 {

    public static int solution(int[] money) {
        int n = money.length;

        /**
         * [Case 1] : 첫 번째 집(n=0)을 털고 마지막 집(n-1)은 제외한 경우
         * 유효 범위 : 0 ~ n-2 (끝집 제외)
         * dp_includeFirst[i] = 0 ~ i 범위에서 얻을 수 있는 최대 금액(단, 집 0은 포함하는 케이스)
         */
        int[] dp_includeFirst = new int[n]; // 0(첫)번째 집부터 i번째 집까지 고려했을 때 훔칠 수 있는 최대 금액
        dp_includeFirst[0] = money[0]; // 첫 번째 집은 반드시 포함된다.
        dp_includeFirst[1] = Math.max(money[0], money[1]); // 두 번째 집은 첫 번째 집과 비교해 더 큰 금액 선택

        for (int i = 2; i < n-1; i++) { // 3번째 집부터 시작 단, 끝집(n-1)은 범위에서 제외
            // 두 선택 중 최댓값
            // 1) i번째 집을 턴다. -> money[i] + dp[i-2]
            // 2) i번째 집을 안턴다. -> dp[i-1]
            dp_includeFirst[i] = Math.max(money[i] + dp_includeFirst[i - 2], dp_includeFirst[i - 1]);
        }

        /**
         * [Case 2] : 첫 번째 집(n=0)을 절대 털지 않고 마지막 집(n-1)은 털 수 있는 경우
         * 유효 범위 : 1 ~ n-1 (첫집 제외)
         * dp_excludeFirst[i] = 1 ~ i 범위에서 얻을 수 있는 최대 금액(단, 집 0은 제외하는 케이스)
         */
        int[] dp_excludeFirst = new int[n]; // 1(두)번재 집부터 i번째 집까지 고려했을 때 훔칠 수 있는 최대 금액
        dp_excludeFirst[0] = 0; // 집 0(첫)은 털지 않는다.
        dp_excludeFirst[1] = money[1]; // 시작을 집 1로 가정한다.
        for (int i = 2; i < n; i++) {           // 끝집(n-1)까지 포함해 계산
            dp_excludeFirst[i] = Math.max(money[i] + dp_excludeFirst[i - 2], dp_excludeFirst[i - 1]);
        }

        /**
         * 최종 정답 :
         * - Case 1의 최댓값은 dp_includeFirst[n-2] : 끝집 제외 범위의 최댓값
         * - Case 2의 최댓값은 dp_excludeFirst[n-1] : 끝집까지 고려한 최댓값
         * 두 값 중 더 큰 값을 반환한다.
         */
        return Math.max(dp_excludeFirst[n-1], dp_includeFirst[n-2]);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] money = new int[size];

        for (int i = 0; i < size; i++) {
            money[i] = sc.nextInt();
        }

        System.out.println(solution(money));
    }

}
