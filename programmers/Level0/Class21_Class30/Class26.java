// 피자 나눠 먹기 (1)
package Level0.Class21_Class30;

import java.util.Scanner;

public class Class26 {

    public static int solution(int n) {
        int answer = n / 7;
        int num = n % 7;

        if (1 <= num && num <= 6) answer += 1;

        return answer;

        /** 보완 코드
         * return (n+6) / 7;
         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(solution(n));
    }

}
