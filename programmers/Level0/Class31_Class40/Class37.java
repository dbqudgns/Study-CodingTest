// 중앙값 구하기
package Level0.Class31_Class40;

import java.util.Arrays;
import java.util.Scanner;

public class Class37 {

    public static int solution(int[] array) {
        int answer = 0;

        Arrays.sort(array);
        int middleIndex = array.length / 2;
        answer = array[middleIndex];

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(solution(array));

    }

}
