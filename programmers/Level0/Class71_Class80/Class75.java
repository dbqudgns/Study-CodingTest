// 문자열 계산하기
package Level0.Class71_Class80;

import java.util.Scanner;

public class Class75 {

    public static int solution(String my_string) {

        String[] my_stringStr = my_string.split(" ");
        int answer = Integer.parseInt(my_stringStr[0]);

        for (int i = 0; i < my_stringStr.length; i++) {
            if (my_stringStr[i].equals("+")) answer += Integer.parseInt(my_stringStr[i+1]);

            else if (my_stringStr[i].equals("-")) answer -= Integer.parseInt(my_stringStr[i+1]);
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String my_string = sc.nextLine();

        System.out.println(solution(my_string));

    }
}
