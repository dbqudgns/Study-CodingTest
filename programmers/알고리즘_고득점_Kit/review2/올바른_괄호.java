package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 올바른_괄호 {

    public static boolean solution(String s) {
        if (s.startsWith(")")) return false;

//        String[] str = s.split(""); // 문자열이 길 경우 매우 비효율적이다.
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (!stack.isEmpty() && c == ')') {
                if (stack.peek().equals('(')) {
                    stack.pop();
                }
            }
            else return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(solution(s));
    }

}
