package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 올바른_괄호 {

    public static boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ')' && stack.isEmpty()) {
                return false;
            }

            else if (s.charAt(i) == ')') {
                stack.pop();
            }

            else stack.add(s.charAt(i));

        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(solution(s));
    }
}
