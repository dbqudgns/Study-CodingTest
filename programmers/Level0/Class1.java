// 나머지 구하기
package Level0;

import java.util.Scanner;

public class Class1 {

    public static int solution(int num1, int num2) {
        int answer = -1;
        answer = num1 % num2;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int solution = solution(num1, num2);

        System.out.println(solution);

    }

}
