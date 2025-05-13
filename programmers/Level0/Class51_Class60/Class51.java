// 가장 큰 수 찾기
package Level0.Class51_Class60;

import java.util.Arrays;
import java.util.Scanner;

public class Class51 {

    public static int[] solution(int[] array) {
        int[] answer = new int[2]; // 배열의 초깃값 : 0

        for (int i = 0; i < array.length; i++) {
            if (array[i] > answer[0]) {
                answer[0] = array[i];
                answer[1] = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(array)));
    }
}
