// 문자열 정렬하기 (1)
package Level0.Class41_Class50;

import java.util.Arrays;
import java.util.Scanner;

public class Class44 {

    public static int[] solution(String my_string) {
        int[] answer = {};

        // 1) 숫자 개수 세기
        int lengthForNum = my_string.length();
        for (char c : my_string.toCharArray()) {
            if ( c >= 'a' && c <= 'z' ) {
                lengthForNum--;
            }
        }

        // 2) 배열에 숫자 담기
        answer = new int[lengthForNum];
        int index = 0;

        for (char c : my_string.toCharArray()) {
            if ( c >= '0' && c <= '9') {
                answer[index++] = c - '0'; // c-'0' : 문자를 int 형에 넣으면 아스키코드 값으로 들어가므로 시작 문자인 '0'을 뺀다.
            }
        }

        Arrays.sort(answer);

        return answer;

        /** 보완 코드
         * my_string = my_string.replaceAll("[a-z]", "");
         *
         * String[] arr = my_string.split("");
         * int[] answer = new int[arr.length];
         *
         * for (int i = 0; i < arr.length; i++) {
         *  answer[i] = Integer.parseInt(arr[i]);
         * }
         *
         * Arrays.sort(answer);
         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String my_string = sc.nextLine();

        System.out.println(Arrays.toString(solution(my_string)));
    }
}
