// 해시
package 알고리즘_고득점_Kit.해시;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 완주하지_못한_선수 {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> correct = new HashMap<>();

        // 참가자 등록 : 동명이인이 있을 경우 +1
        for (String name : participant) {
            correct.put(name, correct.getOrDefault(name, 0) + 1);
        }

        // 완주자에 이름이 있을 경우 value 감소 -1
        for (String name : completion) {
            correct.put(name, correct.get(name) - 1);
        }

        // value가 0이 아닌 사람이 완주하지 못한 사람
        for (Map.Entry<String, Integer> entry : correct.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }

        /**
         * entrySet()은 Map 안의 key-value 쌍을 Set 형태로 반환한다.
         * ex. 위의 correct가 {"lee" : 1, "kim" : 2} 라면
         * correct.entrySet() -> [("lee", 1), ("kim", 2)]
         */

        /**
         * Map.Entry<String, Integer> entry
         * entry는 Map의 한 쌍을 나타낸다.
         * 즉, 하나의 key와 value을 담고 있는 객체이다.
         * ex. entry.getKey() -> "lee"
         * ex. entry.getValue() -> 1
         */

        /** 다른 사람 풀이 : entrySet 말고도 keySet으로 구하는 방법
         * for (String key : correct.keySet()) {
         *    if (correct.get(key) != 0) {
         *      answer = key;
         *      return answer;
         *   }
         * }
         */

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int participantSize = sc.nextInt();
        String[] participant = new String[participantSize];

        for (int i = 0; i < participantSize; i++)
            participant[i] = sc.next();

        int completionSize = sc.nextInt();
        String[] completion = new String[completionSize];

        for (int i = 0; i < completionSize; i++) {
            completion[i] = sc.next();
        }

        System.out.println(solution(participant, completion));
    }

}
