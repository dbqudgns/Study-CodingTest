// 외계어 사전
package Level0.Class81_Class90;

import java.util.Scanner;

public class Class81 {

    public static int solution(String[] spell, String[] dic) {
        int answer = 2;

        for (String str : dic) {
            int count = 0; // spell에 각 원소가 dic의 각 원소 알파벳에 포함되면 증가

            for (String s : spell) {

                if (str.contains(s)) count++;

            }

            if (count == spell.length) {
                answer = 1;
                break;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int spellSize = sc.nextInt();
        String[] spell = new String[spellSize];
        for (int i = 0; i < spellSize; i++) {
            spell[i] = sc.next();
        }

        sc.nextLine();

        int dicSize = sc.nextInt();
        String[] dic = new String[dicSize];
        for (int i = 0; i < dicSize; i++) {
            dic[i] = sc.next();
        }

        System.out.println(solution(spell, dic));
    }
}
