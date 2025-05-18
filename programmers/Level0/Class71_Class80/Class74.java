// 이진수 더하기
package Level0.Class71_Class80;

import java.util.Scanner;

public class Class74 {

    public static String solution(String bin1, String bin2) {
        String answer = "";

        char[] bin1CharArray = bin1.toCharArray();
        char[] bin2CharArray = bin2.toCharArray();
        int digit1 = 0, digit2 = 0;
        int sum1 = 0, sum2 = 0;

        // 1. bin1 문자열을 10진수 정수로 만들기
        for (int i = bin1CharArray.length-1; i >= 0; i--) {
            if (bin1CharArray[i] == '1') {
                double pow = Math.pow(2, digit1++);
                sum1 += (int)pow;
            }
            else digit1++;
        }

        // 2. bin2 문자열을 10진수 정수로 만들기
        for (int i = bin2CharArray.length-1; i >= 0; i--) {
            if (bin2CharArray[i] == '1') {
                double pow = Math.pow(2, digit2++);
                sum2 += (int)pow;
            }
            else digit2++;
        }

        // 3. 10진수 정수 두 값을 더한다.
        int sum = sum1 + sum2;

        // 4. 더한 10진수(sum)을 2진수로 변환한다.
        StringBuilder stringBuilder = new StringBuilder();

        while (sum >= 0) {
            if (sum == 1) {
                stringBuilder.append("1");
                break;
            }
            else if (sum == 0) {
                stringBuilder.append("0");
                break;
            } else {
                stringBuilder.append(sum % 2);
                sum = sum / 2;
            }
        }

        answer = stringBuilder.reverse().toString();

        return answer;

        /** 보완 코드
         * Integer.parseInt(String s, int radix) : s 문자열을 radix 진수로 해석해 10진수 int 값으로 반환
         * int a = Integer.parseInt(bin1, 2)
         * int b = Integer.parseInt(bin2, 2)
         * answer = Integer.toBinaryString(a+b);
         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bin1 = sc.nextLine();
        String bin2 = sc.nextLine();

        System.out.println(solution(bin1, bin2));
    }

}
