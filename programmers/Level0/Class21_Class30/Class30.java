// 최댓값 만들기(1)
package Level0.Class21_Class30;

import java.util.Arrays;
import java.util.Scanner;

public class Class30 {

    public static int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);

        answer = numbers[numbers.length-1] * numbers[numbers.length-2];

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) numbers[i] = sc.nextInt();

        System.out.println(solution(numbers));
    }
}
