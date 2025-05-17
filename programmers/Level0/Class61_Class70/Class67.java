// 숨어있는 숫자의 덧셈 (2)
package Level0.Class61_Class70;

import java.util.Scanner;

public class Class67 {

    public static int solution(String my_string) {
        int answer = 0;
        String[] my_stringArr = my_string.split("[a-zA-Z]");
        // my_stringArr = ["", "", "", "1", "2", "34", "", "", ""];
        // 빈 문자열이 생기는 이유 : 기준 문자 사이에 아무 것도 없을 때만 생긴다 !!

        for (String s : my_stringArr) {
            if (!s.isEmpty()) answer += Integer.parseInt(s);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String my_string = sc.nextLine();
        System.out.println(solution(my_string));
    }


}
