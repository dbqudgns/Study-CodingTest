// 짝수의 합
package Level0.Class11_Class20;

import java.util.Scanner;

public class Class11 {

    public static int solution(int n) {
        int answer = 0;

        for (int i = 2; i<=n; i++) {
            if (i % 2 == 0) {
                answer += i;
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
