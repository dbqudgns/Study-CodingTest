// 369 게임
package Level0.Class51_Class60;

import java.util.Scanner;

public class Class58 {

    public static int solution(int order) {
        int answer = 0;
        String[] orderStr = String.valueOf(order).split("");

        for (String digit : orderStr)
            if (digit.equals("3") || digit.equals("6") || digit.equals("9")) answer++;

        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int order = sc.nextInt();
        System.out.println(solution(order));
    }


}
