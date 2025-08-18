package Level3;

import java.util.*;

// DP : 바텀업 방식
public class N으로_표현 {

    public static int solution(int N, int number) {

        // 1. 메모이제이션 활용 : N을 i번 사용해서 나온 수를 dp[i]에 저장
        // dp[i] : 숫자 N을 정확히 i번 사용해서 만들 수 있는 모든 숫자의 집합
        List<Set<Integer>> dp = new ArrayList<>();

        // 2. 답은 8보다 클 수 없기에 dp는 최대 8번까지 숫자를 사용한 결과를 저장할 수 있도록 초기화
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // 3. 사칙연산으로 숫자 조합
        /**
         * j와 i - j로 숫자 N을 각각 j번, i-j번 사용해서 만든 숫자들을 조합하여 dp[i]를 채운다.
         * 각 숫자 쌍 (a, b)에 대해 사칙연산을 수행하고 결과를 dp[i]에 추가한다.
         */
        for (int i = 1; i <= 8; i++) {

            // 숫자 N을 i번 반복한 문자열을 생성하고 숫자 repeatN을 dp[i]에 추가한다.
            int repeatN = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeatN);

            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {

                        // 덧셈 : a + b
                        dp.get(i).add(a + b);

                        // 뺄셈 : a - b, b - a
                        dp.get(i).add(a - b);
                        dp.get(i).add(b - a);

                        // 곱셈 : a * b
                        dp.get(i).add(a * b);

                        // 나눗셈 : a / b, b / a (0으로 나누는 경우를 제외)
                        if (b != 0) dp.get(i).add(a / b);
                        if (a != 0) dp.get(i).add(b / a);
                    }
                }
            }

            // 4. number가 해당 반복 횟수(i)에 있으면 현재 i를 반환한다.
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int number = sc.nextInt();

        System.out.println(solution(N, number));
    }

}
