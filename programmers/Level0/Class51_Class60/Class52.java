// 문자열 정렬하기
package Level0.Class51_Class60;

import java.util.Arrays;
import java.util.Scanner;

public class Class52 {

    public static String solution(String my_string) {
        String answer = "";

        char[] c = my_string.toLowerCase().toCharArray();

        Arrays.sort(c);

        answer = String.valueOf(c);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String my_string = sc.nextLine();

        System.out.println(solution(my_string));
    }

}
