// 문자열 밀기
package Level0.Class81_Class90;

import java.util.Scanner;

public class Class88 {

    public static int solution(String A, String B) {
        int answer = -1;

        String str = A;

        for (int i = 0; i < A.length(); i++) {
            if (str.equals(B)) {
                answer = i;
                break;
            }

            str = str.charAt(A.length()-1) + str.substring(0, A.length()-1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();
        String B = sc.nextLine();

        System.out.println(solution(A, B));
    }

}
