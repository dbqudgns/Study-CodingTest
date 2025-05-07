// 나이 출력
package Level0.Class1_Class10;

import java.util.Scanner;

public class Class6 {

    public static int solution(int age) {
        int answer = 0;
        answer = 2022 - age + 1;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int age = sc.nextInt();
        int answer = solution(age);

        System.out.println(answer);
    }

}
