// 직각삼각형 출력하기
package Level0.Class31_Class40;

import java.util.Scanner;

public class Class40 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        /** 보완 코드
         * for (int i = 1; i <= n; i++) {
         *    System.out.println("*".repeat(i));
         */

    }

}
