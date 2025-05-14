// 숫자 찾기
package Level0.Class51_Class60;

import java.util.Scanner;

public class Class53 {

    public static int solution(int num, int k) {
        int answer = -1;
        String numStr = String.valueOf(num);
        String[] array = numStr.split("");

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(String.valueOf(k))) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solution(num, k));

    }
}
