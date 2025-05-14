// 피자 나눠 먹기 (2)
package Level0.Class51_Class60;

import java.util.Scanner;

public class Class55 {

    public static int solution(int n) {
        // 피자 한 판당 6조각
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (6 * i % n == 0 ) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
