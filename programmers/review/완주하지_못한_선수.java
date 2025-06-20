package review;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 완주하지_못한_선수 {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> correct = new HashMap<>();

        for (String person : participant) {
            correct.put(person, correct.getOrDefault(person, 0) + 1);
        }

        for (String person : completion) {
            correct.put(person, correct.get(person) - 1);
        }

        for (String key : correct.keySet()) {
            if (correct.get(key) != 0) {
                return key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int participant_size = sc.nextInt();
        String[] participant = new String[participant_size];

        for (int i = 0; i < participant.length; i++) {
            participant[i] = sc.next();
        }

        int completion_size = sc.nextInt();
        String[] completion = new String[completion_size];

        for (int i = 0; i < completion.length; i++) {
            completion[i] = sc.next();
        }

        System.out.println(solution(participant, completion));

    }

}
