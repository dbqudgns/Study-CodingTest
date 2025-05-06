// 피자 나눠 먹기 (3)
package Level0;

import java.util.Scanner;

public class Class20 {

    public static int solution(int slice, int n) {
        int answer = 0;

        answer = n / slice;
        if (n % slice != 0) answer++;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int slice = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(solution(slice, n));
    }

}
