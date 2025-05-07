// 점의 위치 구하기
package Level0.Class21_Class30;

import java.util.Scanner;

public class Class24 {

    public static int solution(int[] dot) {
        int answer = 0;

        if (dot[0] > 0 && dot[1] > 0) answer = 1;
        else if (dot[0] < 0 && dot[1] > 0) answer = 2;
        else if (dot[0] < 0 && dot[1] < 0) answer = 3;
        else answer = 4;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dot = new int[2];

        for (int i = 0; i < 2; i++) {
            dot[i] = sc.nextInt();
        }

        System.out.println(solution(dot));
    }



}
