// 배열의 유사도
package Level0.Class11_Class20;

import java.util.Scanner;

public class Class13 {

    public static int solution(String[] s1, String[] s2) {
        int answer = 0;

        for (String strS1 : s1) {
            for (String strS2 : s2) {
                if (strS1.equals(strS2)) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s1 = sc.nextLine().split(" ");
        String[] s2 = sc.nextLine().split(" ");

        System.out.println(solution(s1, s2));

    }

}
