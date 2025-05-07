// 두 수의 나눗셈
package Level0.Class1_Class10;

import java.util.Scanner;

public class Class8 {

    public static int solution(int num1, int num2) {
        double answer = 0;
        answer = ((double) num1 / num2) * 1000;
        return (int) answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int answer = solution(num1, num2);

        System.out.println(answer);
    }

}
