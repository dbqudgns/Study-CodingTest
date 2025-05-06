// 배열의 평균 값
package Level0;

import java.util.Arrays;
import java.util.Scanner;

public class Class15 {

    public static double solution(int [] numbers) {
        double answer = 0;

        for (int i : numbers) {
            answer += i;
        }

        answer /= numbers.length;

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [] numbers = new int[size];

        for (int i = 0; i<size; i++) {
            int num = sc.nextInt();
            numbers[i] = num;
        }

        System.out.println(Arrays.toString(numbers));

        System.out.println(solution(numbers));
    }
}
