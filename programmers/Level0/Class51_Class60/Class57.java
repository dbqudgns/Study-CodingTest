// 배열 회전시키기
package Level0.Class51_Class60;

import java.util.Arrays;
import java.util.Scanner;

public class Class57 {

    public static int[] solution(int[] numbers, String direction) {
        int [] answer = {};
        answer = new int[numbers.length];

        if (direction.equals("right")) {
            for (int i = 0; i < numbers.length; i++) {
                if (i == numbers.length - 1) {
                    answer[0] = numbers[i];
                }
                else {
                    answer[i+1] = numbers[i];
                }
            }
        }
        else if (direction.equals("left")) {
            for (int i = 0; i < numbers.length; i++) {
                if (i == 0) {
                    answer[numbers.length-1] = numbers[i];
                }
                else {
                    answer[i-1] = numbers[i];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }

        sc.nextLine();

        String direction = sc.nextLine();

        System.out.println(Arrays.toString(solution(numbers, direction)));
    }

}
