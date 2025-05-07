// 뒤집힌 문자열
package Level0.Class21_Class30;

import java.util.Scanner;

public class Class21 {

    public static String solution(String my_string) {
        String answer = "";

        for(int i = my_string.length()-1; i>=0; i--) {
            char temp = my_string.charAt(i);
            answer += temp;
        }
        return answer;

        /** 보완 코드
         * StringBuilder answer = new StringBuilder();
         * answer.append(my_string);
         * answer.reverse();
         * return answer.toString();
         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String my_string = sc.nextLine();

        System.out.println(solution(my_string));
    }

}
