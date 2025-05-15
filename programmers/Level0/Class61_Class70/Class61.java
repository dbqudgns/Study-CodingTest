// 모스 부호
package Level0.Class61_Class70;

import java.util.Scanner;

public class Class61 {

    public static String solution(String letter) {
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] letter_array = letter.split(" ");

        for (String s : letter_array) {
            for (int i = 0; i < morse.length; i++) {
                if (morse[i].equals(s)) {
                    answer += (char)(97 + i);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String letter = sc.nextLine();

        System.out.println(solution(letter));
    }
}
