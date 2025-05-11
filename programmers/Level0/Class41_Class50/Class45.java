// 숨어있는 숫자의 덧셈(1)
package Level0.Class41_Class50;

import java.util.Scanner;

public class Class45 {

    public static int solution(String my_string) {
        int answer = 0;

        String[] arr = my_string.replaceAll("[a-z, A-Z]", "").split("");

        for (String num : arr) answer += Integer.parseInt(num);

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String my_string = sc.nextLine();

        System.out.println(solution(my_string));
    }

}
