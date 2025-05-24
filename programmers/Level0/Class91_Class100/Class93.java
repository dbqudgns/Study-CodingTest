// O X 퀴즈
package Level0.Class91_Class100;

import java.util.Arrays;
import java.util.Scanner;

public class Class93 {

    public static String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length]; // O, X 저장
        int count = 0;

        for (String str : quiz) {
            String[] str_array = str.split(" "); // 1. 각 문자열을 공백을 기준으로 split 진행

            int x = Integer.parseInt(str_array[0]);
            int y = Integer.parseInt(str_array[2]);
            int z = Integer.parseInt(str_array[4]);

            if (str_array[1].equals("+")) { // 2. split된 인덱스 중 1은 연산 기호이므로 조건문을 통해 연산 수행
                if (x + y == z) answer[count++] = "O"; // 3. 옳으면 answer 배열에 O 저장
                else answer[count++] = "X";
            } else if (str_array[1].equals("-")) {
                if (x - y == z) answer[count++] = "O";
                else answer[count++] = "X"; // 4. 틀리면 answer 배열에 X 저장
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        sc.nextLine();
        String[] quiz = new String[size];

        for (int i = 0; i < size; i++) {
            quiz[i] = sc.nextLine();
        }

        System.out.println(Arrays.toString(solution(quiz)));
    }

}
