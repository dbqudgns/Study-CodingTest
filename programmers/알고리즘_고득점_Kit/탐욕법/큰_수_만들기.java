package 알고리즘_고득점_Kit.탐욕법;

import java.util.*;

public class 큰_수_만들기 {

    public static String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            while(!stack.isEmpty() &&
                    stack.peek() < number.charAt(i) &&
                      k-- > 0) {
                stack.pop();

            }

            stack.push(number.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        if (k > 0) {
            return sb.reverse().toString().substring(0, sb.toString().length() - k);
        }

        return sb.reverse().toString();


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        int k = sc.nextInt();

        System.out.println(solution(number, k));
    }

}
