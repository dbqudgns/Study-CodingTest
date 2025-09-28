package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 완주하지_못한_선수 {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            if (!map.containsKey(participant[i])) {
                map.put(participant[i], 0);
            }
            else {
                map.replace(participant[i], map.get(participant[i]), map.get(participant[i]) + 1);
            }

        }

        for (int i = 0; i < completion.length; i++) {
            map.replace(completion[i], map.get(completion[i]), map.get(completion[i]) - 1);
        }

        for (int i = 0; i < map.size(); i++) {
            if (map.get(participant[i]) != -1) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        sc.nextLine();
        String[] participant = new String[size];
        for (int i = 0; i < size; i++) {
            participant[i] = sc.nextLine();
        }

        String[] completion = new String[size-1];
        for (int i = 0; i < size-1; i++) {
            completion[i] = sc.nextLine();
        }

        System.out.println(solution(participant, completion));

    }
}
