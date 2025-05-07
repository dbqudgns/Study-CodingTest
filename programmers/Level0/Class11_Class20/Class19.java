// 특정 문자 제거하기
package Level0.Class11_Class20;

import java.util.Scanner;

public class Class19 {

    public static String solution(String my_string, String letter) {
        String answer = "";

        for (char c : my_string.toCharArray()) {
            if (c == letter.charAt(0)) {
                continue;
            }
            answer += c;
        }

        return answer;

        /** 보완 코드
         * answer = my_string.replace(letter, "");
         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String my_string = sc.nextLine();
        String letter = sc.nextLine();

        System.out.println(solution(my_string, letter));

    }
}
