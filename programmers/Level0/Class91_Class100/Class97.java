// 분수의 덧셈
package Level0.Class91_Class100;

import java.util.Arrays;
import java.util.Scanner;

public class Class97 {

    public static int[] solution (int numer1, int denom1, int numer2, int denom2) {

        int[] answer = new int[2]; // 각각 분자, 분모를 담음

        // 1. 2개의 분수 분모 통일 값 찾기
        int common = 0;
        if (denom1 == denom2) {
            common = denom1;
        }
        else  common = denom1 * denom2;

        // 2. 첫 번째 분수의 통일 값 기준으로 분자 변환
        int mul1 = common / denom1;
        numer1 = numer1 * mul1;

        // 3. 두 번째 분수의 통일 값 기준으로 분자 변환
        int mul2 = common / denom2;
        numer2 = numer2 * mul2;

        // 4. 두 분수의 분자 덧셈
        int numer = numer1 + numer2;

        // 5. common과 number 최대 공약수 구하기
        int max_mul = 1;
        int max = common;
        if (numer > common) {
            max = numer;
        }
        for (int i = max; i > 0; i--) {
            if (common % i == 0 && numer % i == 0) {
                max_mul *= i;
                break;
            }
        }

        // 6. 최대 공약수를 통해 기약 분수 구하기
        answer[0] = numer / max_mul;
        answer[1] = common / max_mul;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numer1 = sc.nextInt();
        int denom1 = sc.nextInt();
        int numer2 = sc.nextInt();
        int denom2 = sc.nextInt();

        System.out.println(Arrays.toString(solution(numer1, denom1, numer2, denom2)));
    }
}
