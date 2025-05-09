// 배열 자르기
package Level0.Class31_Class40;

import java.util.Arrays;
import java.util.Scanner;

public class Class34 {

    public static int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2-num1+1];

        int num = 0;
        for (int i = num1; i <= num2; i++) {
            answer[num] = numbers[i];
            num++;
        }

        return answer;

        /** 보충 코드
         * Arrays.copyOfRange(복사할 배열, 복사 시작 인덱스, 복사 끝 인덱스(-1))
         * Arrays.copyOfRange(numbers, num, num2+1)
         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] numbers = new int[size];
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(numbers, num1, num2)));
    }

}
