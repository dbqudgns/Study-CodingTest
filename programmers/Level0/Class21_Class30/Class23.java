// 문자 반복 출력하기
package Level0.Class21_Class30;

import java.util.Scanner;

public class Class23 {

    public static String solution(String my_string, int n) {
        String answer = "";

        // toCharArray() : String 문자열을 char형 배열로 바꿔서 반환해주는 메서드
        for (char c : my_string.toCharArray()) {

            for (int i = 1; i<= n; i++) {
                answer += c;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String my_string = sc.nextLine();
        int n = sc.nextInt();

        System.out.println(solution(my_string, n));
    }
}
