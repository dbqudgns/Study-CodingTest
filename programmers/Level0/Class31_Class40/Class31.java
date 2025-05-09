// 모음 제거
package Level0.Class31_Class40;

import java.util.Scanner;

public class Class31 {

    public static String solution(String my_string) {
        String answer = "";

        for (char c : my_string.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                continue;
            }
            answer = answer + c;
        }

        return answer;

        /**
         * answer = my_string.replaceAll("[aeiou]", "");
         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String my_string = sc.nextLine();

        System.out.println(solution(my_string));

    }

}
