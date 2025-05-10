// 옷가게 할인 받기
package Level0.Class31_Class40;

import java.util.Scanner;

public class Class39 {

    public static int solution(int price) {

        /** 내가 작성한 코드 (틀림)
         *  int answer = 0;
         *
         *         if (price >= 500000) {
         *             int num = price * 20/100;
         *             answer = price - num;
         *         }
         *
         *         else if (price >= 300000) {
         *             int num = price * 10/100;
         *             answer = price - num;
         *         }
         *
         *         else if (price >= 100000) {
         *             int num = price * 5/100;
         *             answer = price - num;
         *         }
         *
         *         else answer = price;
         *
         *         return answer;
         */

        int answer = 0;

        if (price >= 500000) return price * 80 / 100;

        else if (price >= 300000) return price * 90 / 100;

        else if (price >= 100000)  return price * 95 / 100;

        else answer = price;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int price = sc.nextInt();

        System.out.println(solution(price));
    }

}
