package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 타겟_넘버 {

    public static int solution(int[] numbers, int target) {

        int answer = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        for (int num : numbers) {

            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int value = queue.remove();

                queue.add(value + num);
                queue.add(value - num);
            }
        }

        while(!queue.isEmpty()) {
            int value = queue.remove();

            if (value == target) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] numbers = new int[5];
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(solution(numbers, target));
    }

}
