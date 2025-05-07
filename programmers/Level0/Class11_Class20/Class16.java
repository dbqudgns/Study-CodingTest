// 배열 뒤집기
package Level0.Class11_Class20;

import java.util.Arrays;
import java.util.Scanner;

public class Class16 {

    public static int[] solution(int[] num_list) {
        int[] answer = {};
        answer = new int[num_list.length];

        for (int i = 0; i <= num_list.length/2; i++) {
            int num = num_list[i];
            answer[i] = num_list[num_list.length-i-1];
            answer[num_list.length-i-1] = num;
        }

        /** 보완 코드
         * for (int i = 0; i < num_list.length; i++) {
         *      answer[i] = num_list[num_list.length-i-1];
         *  }
         */

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] num_list = new int[size];

        for (int i = 0; i < size; i++) {
            num_list[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(num_list)));

    }

}
