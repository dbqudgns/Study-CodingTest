// 가까운 수
package Level0.Class61_Class70;

import java.util.Scanner;

public class Class68 {

    public static int solution(int[] array, int n) {

        int answer = array[0];

        int min = Math.abs(array[0] - n);

        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i] - n) <= min) {
                if ((Math.abs(array[i] - n) == min) && (answer < array[i])) {
                    continue;
                }
                min = Math.abs(array[i] - n);
                answer = array[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int [] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        int n = sc.nextInt();

        System.out.println(solution(array, n));
    }

}
