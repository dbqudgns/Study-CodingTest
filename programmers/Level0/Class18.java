// 짝수 홀수 개수
package Level0;

import java.util.Arrays;
import java.util.Scanner;

public class Class18 {

    public static int[] solution(int[] num_list) {
        int [] answer = {0, 0};

        for (int num : num_list) {
            if (num % 2 == 0) answer[0]++;
            else answer[1]++;
        }

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
