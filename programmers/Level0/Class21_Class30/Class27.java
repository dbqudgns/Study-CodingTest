// 삼각형의 완성조건 (1)
package Level0.Class21_Class30;

import java.util.Arrays;
import java.util.Scanner;

public class Class27 {

    public static int solution(int[] sides) {

        /** 나의 문제 풀이 (막힘)
         * int answer = 0;
         *         int maxNum = 0;
         *         int maxIndex = 0;
         *         for (int i = 0; i<3; i++) {
         *             if (sides[i] > maxNum) {
         *                 maxNum = sides[i];
         *                 maxIndex = i;
         *             }
         *         }
         */

        int answer = 0;
        Arrays.sort(sides);

        if (sides[2] < sides[0] + sides[1]) answer = 1;
        else answer = 2;

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sides = new int[3];

        for (int i = 0; i < sides.length; i++) {
            sides[i] = sc.nextInt();
        }

        System.out.println(solution(sides));
    }

}
