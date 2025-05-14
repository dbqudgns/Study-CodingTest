// 외계행성의 나이
package Level0.Class51_Class60;

import java.util.Scanner;

public class Class56 {

    public static String solution(int age) {
        String answer = "";
        String[] ageString = String.valueOf(age).split("");

        for (String ageStr : ageString) {
            switch (ageStr) {
                case "0" :
                    answer += "a";
                    break;
                case "1" :
                    answer += "b";
                    break;
                case "2" :
                    answer += "c";
                    break;
                case "3" :
                    answer += "d";
                    break;
                case "4" :
                    answer += "e";
                    break;
                case "5" :
                    answer += "f";
                    break;
                case "6" :
                    answer += "g";
                    break;
                case "7" :
                    answer += "h";
                    break;
                case "8" :
                    answer += "i";
                    break;
                case "9" :
                    answer += "j";
                    break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        System.out.println(solution(age));
    }

}
