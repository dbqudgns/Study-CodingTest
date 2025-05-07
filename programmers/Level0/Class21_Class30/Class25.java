// 편지
package Level0.Class21_Class30;

import java.util.Scanner;

public class Class25 {

    public static int solution(String message) {
        int answer = 0;

        answer = message.length() * 2;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();

        System.out.println(solution(message));

    }

}
