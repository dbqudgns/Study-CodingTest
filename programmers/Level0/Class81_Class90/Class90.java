// 유한소수 판별하기
package Level0.Class81_Class90;

import java.util.Scanner;

public class Class90 {

    public static int solution(int a, int b) {

        int answer = 1; // 유한소수 or 무한소수
        int max_divisor = 0; // 최대 공약수

        // 1. 분자와 분모 최대 공약수 구하기
        for (int i = 1; i <= b; i++) {
            if (a % i == 0 && b % i == 0) max_divisor = i;
        }

        // 2. 분모를 최대공약수로 나누기
        b /= max_divisor;

        // 3. 분모가 2 또는 5로만 이루어지면 유한소수 아니면 무한소수
        while (b > 1) {
            if (b % 2 == 0) {
                b /= 2;
            }
            else if (b % 5 == 0) {
                b /= 5;
            }
            else {
                answer = 2;
                return answer;
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(solution(a, b));
    }
}
