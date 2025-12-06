package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 큰_수_만들기 {

    public static String solution(String number, int k) {
        char[] result = new char[number.length() - k];

        Stack<Character> stack = new Stack<>(); // Stack : First in Last out

        for (int i = 0; i < number.length(); i++) {
            while(!stack.isEmpty() && stack.peek() < number.charAt(i) && k-- > 0) {
                stack.pop();
            }

            stack.push(number.charAt(i));
        }

        for (int i = 0; i < result.length; i++) {
            // get(인덱스)일 경우 맨 처음부터 들어온 것부터
            // index가 0으로 지정 돼 해당 값을 얻을 수 있다.
            result[i] = stack.get(i);
        }

        return new String(result);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        int k = sc.nextInt();

        System.out.println(solution(number, k));
    }
}
