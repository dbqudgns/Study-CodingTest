// 제곱수 판별하기
package Level0;

import java.util.Scanner;

public class Class17 {

    public static int solution(int n) {
        int answer = 2;

        for(int i = 1; i<n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    answer = 1;
                    break;
                }
            }

        }

        return answer;
    }

    /** 보완 코드
     * if (n % Math.sqrt(n) == 0) return 1;
     * else return 2;
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }

}
