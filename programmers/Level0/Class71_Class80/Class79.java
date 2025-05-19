// 삼각형의 완성조건 (2)
package Level0.Class71_Class80;

import java.util.Arrays;
import java.util.Scanner;

public class Class79 {

    // 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 한다.
    public static int solution(int[] sides) {

        int answer = 0;
        int case1;
        int case2;

        Arrays.sort(sides);

        // 1. 가장 긴 변이 sides 중에 있을 경우
        case1 = sides[1] - (sides[1] - sides[0] + 1) + 1;


        // 2. 가장 긴 변이 나머지 변일 경우
        case2 = sides[1] + sides[0] - sides[1] - 1;

        answer = case1 + case2;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sides = new int[2];

        for (int i = 0; i < sides.length; i++) {
            sides[i] = sc.nextInt();
        }

        System.out.println(solution(sides));
    }

}
