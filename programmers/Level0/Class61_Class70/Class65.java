// 진료 순서 정하기
package Level0.Class61_Class70;

import java.util.Arrays;
import java.util.Scanner;

public class Class65 {

    public static int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < emergency.length; j++) {
                if (emergency[i] < emergency[j]) answer[i]++;
            }
            answer[i]++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] emergency = new int[size];

        for (int i = 0; i < size; i++) {
            emergency[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(emergency)));
    }

}
