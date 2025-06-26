// 큐
package Level2;

import java.util.*;

public class 올바른_괄호 {

    public static boolean solution(String s) {

        // 1. 괄호를 담을 Queue 선언
        Queue<String> que = new ArrayDeque<>();
        String[] split = s.split("");
        boolean answer = true;

        // 2. Queue에 값을 넣을 시 아래와 같은 규칙을 지켜야 한다.
        for (int i = 0; i < split.length; i++) {

            // 규칙1. 처음에 넣을 값이 ")"일 경우 false를 반환한다.
            if (split[i].equals(")") && que.isEmpty()) {
                return false;
            }
            // 규칙2. 넣을 값이 ")"일 경우 poll()을 통해 "("을 뺀다.
            else if (split[i].equals(")")) {
                que.poll();
            }
            // 규칙3. "("는 큐에 넣는다.
            else que.add(split[i]);
        }

        // 규칙4. 문자열을 다 순회한 경우 Queue에 문자가 남아 있을 경우 false를 반환한다.
        if (!que.isEmpty()) return false;


        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));

    }

}
