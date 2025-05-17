// 팩토리얼
package Level0.Class61_Class70;

import java.util.Scanner;

public class Class66 {

    public static int solution(int n) {
        int answer = 0;
        int factorial = 1;

        // n의 범위 값(10!)이 정해져 있으므로 최대 팩토리얼은 10
        //for (int i = 1; i <= 10; i++) {
        int i = 1;
        while (true) {
            factorial *= i;

            if (factorial == n) {
                answer = i;
                break;
            } else if (n < factorial) {
                answer = (i - 1);
                break;
            } else i++;
        }


        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
