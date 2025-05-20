// 종이 자르기
package Level0.Class81_Class90;

import java.util.Scanner;

public class Class82 {

    public static int solution(int M, int N) {

        int answer = M * N - 1;

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        System.out.println(solution(M, N));
    }
}
