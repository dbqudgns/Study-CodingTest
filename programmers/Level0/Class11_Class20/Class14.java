// 문자열안에 문자열
package Level0.Class11_Class20;

import java.util.Scanner;

public class Class14 {

    public static int solution(String str1, String str2) {
        int answer = 0;

        if (str1.contains(str2)) answer = 1;
        else answer = 2;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println(solution(str1, str2));

    }

}
