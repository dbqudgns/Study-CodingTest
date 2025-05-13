// 대문자와 소문자
package Level0.Class41_Class50;

import java.util.Scanner;

public class Class48 {

    public static String solution(String my_string) {
        String answer = "";

        for (char c : my_string.toCharArray()) {
            if (c >= 'a' && c <= 'z') answer += Character.toUpperCase(c);

            else answer += Character.toLowerCase(c);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String my_string = sc.nextLine();

        System.out.println(solution(my_string));
    }
}
