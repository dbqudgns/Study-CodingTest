// n의 배수 고르기
package Level0.Class51_Class60;

import java.util.Arrays;
import java.util.Scanner;

public class Class54 {

    public static int[] solution(int n, int[] numlist) {
        int[] answer = {};
        int answer_size = 0;

        for (int num : numlist) {
            if (num % n == 0) {
                answer_size++;
            }
        }

        answer = new int[answer_size];

        int index = 0;
        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] % n == 0) {
                answer[index++] = numlist[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int size = sc.nextInt();
      int[] numlist = new int[size];
      int n = sc.nextInt();

      for (int i = 0; i < size; i++) numlist[i] = sc.nextInt();

      System.out.println(Arrays.toString(solution(n, numlist)));

    }
}
