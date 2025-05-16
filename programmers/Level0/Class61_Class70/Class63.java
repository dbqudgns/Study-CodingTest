// A로 B 만들기
// before을 뒤집어서 after와 일치하는 것이 아닌 before의 순서를 이리저리 바꿨을 때를 구하는 것
package Level0.Class61_Class70;

import java.util.Arrays;
import java.util.Scanner;

public class Class63 {

    public static int solution(String before, String after) {
        int answer = 0;

        char[] beforeArray = before.toCharArray();
        char[] afterArray = after.toCharArray();

        Arrays.sort(beforeArray);
        Arrays.sort(afterArray);

        String beforeString = new String(beforeArray);
        String afterString = new String(afterArray);

        if (beforeString.equals(afterString)) return answer = 1;
        else return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String before = sc.nextLine();
        String after = sc.nextLine();
        System.out.println(solution(before, after));
    }

}
