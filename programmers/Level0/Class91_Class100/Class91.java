// 다항식 더하기
package Level0.Class91_Class100;

import java.util.Scanner;

public class Class91 {

    public static String solution(String polynomial) {

        String answer = ""; // 모든 합 더한 후 문자열로 연결
        int sum_x = 0; // 일차항 계수 합
        int sum_num = 0; // 상수항 합

        // 1. polynomial 문자열을 공백을 기준으로 split
        String[] polynomial_str = polynomial.split(" ");

        // 2. 반복문을 통해 일차항(x)의 계수를 파악 후 합한 값 저장
        for (int i = 0; i < polynomial_str.length; i++) {
            if (polynomial_str[i].contains("x")) {

                if (polynomial_str[i].equals("x")) {
                    sum_x += 1;
                    System.out.println(sum_x);
                }

                else {
                    String[] polynomial_char = polynomial_str[i].split("");

                    String num = "";
                    for (int j = 0; j < polynomial_char.length; j++) {
                        if (!polynomial_char[j].equals("x")) {
                            num += polynomial_char[j];
                        }
                    }

                    sum_x += Integer.parseInt(num);
                    System.out.println(sum_x);
                }
            }
        }

        // 3. 반복문을 통해 상수항 파악 후 합한 값 저장
        for (int i = 0; i < polynomial_str.length; i++) {
            if (!polynomial_str[i].contains("x")) {
                if (!polynomial_str[i].contains("+")) {
                    sum_num += Integer.parseInt(polynomial_str[i]);
                    System.out.println(sum_num);
                }
            }
        }

        // 4. 저장된 값들 문자열로 이어 붙이기
        if (sum_x == 1) {
            if (sum_num == 0) {
                answer = "x";
            }
            else {
                answer = "x + " + sum_num;
            }
        }
        else if (sum_x == 0) answer = String.valueOf(sum_num);

        else if (sum_num == 0) {
            answer = sum_x + "x";
        }
        else answer = sum_x + "x + " + sum_num;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String polynomial = sc.nextLine();
        System.out.println(solution(polynomial));
    }

}
