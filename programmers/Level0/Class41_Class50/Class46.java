// 최댓값 만들기(2)
package Level0.Class41_Class50;
import java.util.Arrays;
import java.util.Scanner;

public class Class46 {

    public static int solution(int[] numbers) {
            int answer = 0;

            Arrays.sort(numbers);

            int first = numbers[0] * numbers[1];
            int two = numbers[numbers.length-1] * numbers[numbers.length-2];

            answer = first > two ? first : two;
            return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(solution(numbers));

    }

}
