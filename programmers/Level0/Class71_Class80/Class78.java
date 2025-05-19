// 구슬을 나누는 경우의 수
package Level0.Class71_Class80;

import java.util.Scanner;

public class Class78 {

    public static int solution(int balls, int share) {
        long answer = 1;
        int shareIndex = 1;

        for (int i = balls-share+1; i <= balls; i++) {
            answer *= i;
            answer /= shareIndex;
            shareIndex++;
        }

        return (int)answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balls = sc.nextInt();
        int share = sc.nextInt();

        System.out.println(solution(balls, share));
    }

}
