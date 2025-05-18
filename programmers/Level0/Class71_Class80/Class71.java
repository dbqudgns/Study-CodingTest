// 컨트롤 제트
package Level0.Class71_Class80;

import java.util.Scanner;

public class Class71 {

    public static int solution(String s) {

        int answer = 0;
        String[] sStr = s.split(" ");

        for (int i = 0; i < sStr.length; i++) {
            if (sStr[i].equals("Z")) {
                answer -= Integer.parseInt(sStr[i-1]);
            }
            else answer += Integer.parseInt(sStr[i]);
        }

        return answer;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(solution(s));

    }
}
