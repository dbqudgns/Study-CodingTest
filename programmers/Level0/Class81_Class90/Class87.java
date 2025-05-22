// 저주의 숫자 3
package Level0.Class81_Class90;

import java.util.Scanner;

public class Class87 {

    public static int solution(int n) {

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer++;
            String str = String.valueOf(answer);

            while (answer % 3 == 0 || str.contains("3")) {
                answer++;
                str = String.valueOf(answer);
            }

        }

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(solution(n));
    }

}
