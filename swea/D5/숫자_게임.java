package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자_게임 {

    static int[] dir = {10, 100, 1000, 10000};
    static int[] dp; // 1~99999에서 분할 시 최태 턴수를 저장 하는 변수 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new int[10000];

        for (int i = 11; i < 10000; i++) {
            solution(i, i, 1, 0);
        }

        int N = Integer.parseInt(br.readLine());
        System.out.println(dp[N]);
    }

    public static void solution(int N, int quotient, int remainder, int depth) {

        // 기저 조건
        if (quotient == 0) {
            dp[N] = Math.max(dp[N], dp[remainder] + 1);
            return;
        }

        for (int i = 0; i < 4; i++) {

            // 처음부터(depth == 0) N이 dir보다 작다면 이상한 값이 dp[N]에 넣어진다.
            if (depth == 0 && N < dir[i]) {
                continue;
            }

            int q = quotient / dir[i];
            int r = quotient % dir[i];

            solution(N, q, remainder * r, depth + 1);

            // 남은 앞부분 숫자가 나눈 값보다 작다면 다음 나눈 값도 작으니 break;
            // 왜냐하면 다음 몫(i+1로 나눌 때)도 0이 나와서 무의미한 계산이다.
            if (quotient < dir[i]) {
                break;
            }
        }
    }
}