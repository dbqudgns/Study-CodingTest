// 머쓱이보다 키 큰 사람
package Level0.Class31_Class40;

import java.util.Scanner;

public class Class33 {

    public static int solution(int[] array, int height) {
        int answer = 0;

        for (int num : array) {
            if (num > height) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = new int[sc.nextInt()];
        int height = sc.nextInt();

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(solution(array, height));
    }

}
