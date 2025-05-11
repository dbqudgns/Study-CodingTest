// 가위 바위 보
package Level0.Class41_Class50;

import java.util.Scanner;

public class Class42 {

    public static String solution(String rsp) {
        String answer = "";
        for (char c : rsp.toCharArray()) {
            if (c == '2') answer += "0";
            else if (c == '0') answer += "5";
            else if (c == '5') answer += "2";
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rsp = sc.nextLine();

        System.out.println(solution(rsp));
    }




}
