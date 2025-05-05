// 양꼬치
package Level0;

import java.util.Scanner;

public class Class10 {

    public static int solution(int n, int k) {
        int answer = 0;

        int minus = 0;
        if (n >= 10) {
            minus = n / 10;
        }
        answer = n * 12000 + k * 2000 - minus * 2000;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int answer = solution(n, k);
        System.out.println(answer);
    }
}
