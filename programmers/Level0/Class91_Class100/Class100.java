// 옹알이 (1)
package Level0.Class91_Class100;

import java.util.Scanner;

public class Class100 {

    public static int solution(String[] babbling) {
        int answer = 0;
        String[] talks = {"aya", "ye", "woo", "ma"};

        for (String baby : babbling) {
            for (String talk : talks) {
                if (baby.contains(talk)) {
                    baby = baby.replace(talk, " ");
                }
            }

            baby = baby.replace(" ", "");
            if (baby.equals("")) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String[] babbling = new String[size];
        for (int i = 0; i < size; i++) {
            babbling[i] = sc.next();
        }

        System.out.println(solution(babbling));
    }
}
