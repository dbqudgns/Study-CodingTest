package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 주식가격 {

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int price : prices) {
            queue.add(price);
        }

        int answerIndex = 0;
        while(!queue.isEmpty()) {

            int poll = queue.poll();
            int count = 0;

            for (int nextPrice : queue) {
                if (nextPrice >= poll) {
                    count++;
                }
                else {
                    count++;
                    break;
                }
            }

            answer[answerIndex++] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] prices = new int[size];

        for (int i = 0; i < size; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(prices)));
    }

}
