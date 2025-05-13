// 암호 해독
package Level0.Class41_Class50;

import java.util.Scanner;

public class Class47 {

    public static String solution(String cipher, int code) {
        String answer = "";
        int size = cipher.length();
        int sum = code;
        char[] array = cipher.toCharArray();

        for (int i = sum; i <= size; i = sum) {
            answer += array[i - 1];
            sum += code;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cipher = sc.nextLine();
        int code = sc.nextInt();

        System.out.println(solution(cipher, code));
    }

}
