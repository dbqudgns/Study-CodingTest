// 배열 원소의 길이
package Level0;

import java.util.Arrays;
import java.util.Scanner;

public class Class12 {

    public static int[] solution(String[] strlist) {
        int[] answer = {};
        answer = new int[strlist.length];

        int num = 0;
        for (String str : strlist) {
            int length = str.length();
            answer[num] = length;
            num++;
        }

        /** 보완 코드
         for (int i = 0; i<strlist.length; i++) {
            answer[i] = strlist[i].length();
        }
         **/

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] strlist = new String[n];
        for (int i = 0; i<n; i++) {
            String string = sc.next();
            strlist[i] = string;
        }

        int[] answer = solution(strlist);

        System.out.println(Arrays.toString(Arrays.stream(answer).toArray()));

    }

}

/**
 * String 문자열을 반환하는 입력 메서드
 * next() : 공백(스페이스, 탭 등)을 기준으로 입력을 끊어 반환하지만 개행 문자(\n)는 포함하지 않는다. => 즉, 버퍼에 개행 문자가 존재!
 * nextLine() : 엔더(Enter)를 칠 때까지 모든 문자열을 반환하고 개행 문자(\n)까지 포함한다. => 하지만 반환 값은 개행 문자를 포함하지 않고 문자열만 반환!
 *            : 개행 문자(\n)을 기준으로 반환한다 !!
 */