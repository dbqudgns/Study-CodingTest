// 개미 군단
package Level0.Class41_Class50;

import java.util.Scanner;

public class Class41 {

    public static int solution(int hp) {
        int answer = 0;

        answer = hp / 5;
        hp = hp % 5;

        answer += hp / 3;
        hp = hp % 3;

        answer += hp;

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hp = sc.nextInt();

        System.out.println(solution(hp));

    }

}
