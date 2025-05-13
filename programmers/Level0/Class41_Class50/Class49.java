// 인덱스 바꾸기
package Level0.Class41_Class50;

import java.util.Scanner;

public class Class49 {

    public static String solution(String my_string, int num1, int num2) {
        String answer = "";

        char[] array = my_string.toCharArray();
        array[num1] = my_string.charAt(num2);
        array[num2] = my_string.charAt(num1);
        answer = new String(array);

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String my_string = sc.nextLine();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(solution(my_string, num1, num2));

    }

}
