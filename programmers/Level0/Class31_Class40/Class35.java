// 중복된 숫자 개수
package Level0.Class31_Class40;

import java.util.Scanner;

public class Class35 {

    public static int solution(int[] array, int n) {
        int answer = 0;
        for (int i : array) {
            if (i == n) {
                answer ++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];
        int n = sc.nextInt();

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(solution(array, n));
    }

}
