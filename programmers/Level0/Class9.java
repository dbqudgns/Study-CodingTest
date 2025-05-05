// 각도기
package Level0;

import java.util.Scanner;

public class Class9 {

    public static int solution(int angle) {
        int answer = 0;

        if (0 < angle && angle < 90) answer = 1;
        else if (angle == 90) answer = 2;
        else if (90 < angle && angle < 180) answer = 3;
        else answer = 4;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int angle = sc.nextInt();
        int answer = solution(angle);
        System.out.println(answer);
    }

}
