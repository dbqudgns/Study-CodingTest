package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 주식가격 {

    public static int[] solution(int[] prices) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {

            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - index - 1;
        }

        return answer;
    }

        public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));

        int size = sc.nextInt();
        int[] prices = new int[size];

        for (int i = 0; i < size; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(prices)));
    }
}
