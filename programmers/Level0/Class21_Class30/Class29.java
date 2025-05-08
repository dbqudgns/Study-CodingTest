// 세균 증식
package Level0.Class21_Class30;

import java.util.Scanner;

public class Class29 {

    public static int solution(int n, int t) {
        int answer = n;

        for (int i = 1; i <= t; i++) {
            answer *= 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        System.out.println(solution(n, t));
    }

}
