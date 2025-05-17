// 한 번만 등장한 문자
package Level0.Class61_Class70;

import java.util.*;

public class Class69 {

    public static String solution(String s) {
        String answer = "";

        // 1. HashMap을 통해 특정 문자 개수 카운트
        Map<String, Integer> map = new HashMap<>();
        for (String c : s.split("")) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 2. 키 중 값이 1 인 키를 answer에 연결
        for (String c : map.keySet()) {
            if (map.get(c) == 1) {
                answer += c;
            }
        }

        // 3. Array를 이용한 정렬
        char[] arr = answer.toCharArray();
        Arrays.sort(arr);
        answer = new String(arr);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }

}
