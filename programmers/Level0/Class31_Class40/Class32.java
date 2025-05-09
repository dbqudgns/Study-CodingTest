// 자릿수 더하기
package Level0.Class31_Class40;

import java.util.Scanner;

public class Class32 {

    public static int solution(int n) {
        int answer = 0;
        while (n > 0) {
            int remain = n % 10;
            answer += remain;
            n /= 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(solution(n));

    }

}
