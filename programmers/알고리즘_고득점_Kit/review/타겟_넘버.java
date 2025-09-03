package 알고리즘_고득점_Kit.review;

import java.util.*;

// BFS로 풀어보자
public class 타겟_넘버 {

    public static int solution(int[] numbers, int target) {

        int answer = 0;

        // 1. 각 number를 +, - 시 누적 값을 저장할 Queue 선언
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        // 2. 순회 시 Queue에 누적된 값에 각 number를 +, - 연산을 수행한다.
        for (int num : numbers) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int value = queue.remove();

                // numbers : [1, 1, 1, 1, 1] 기준
                queue.add(value + num); // 1 -> 2, 0 -> 3, 1, 1, -1 -> ... : 한 순회 시 len의 길이가 2의 배수로 늘어난다.
                queue.add(value - num); // -1 -> 0, -2 -> 1, -1, -1. -3 -> ... :  한 순회 시 len의 길이가 2의 배수로 늘어난다.
            }
        }

        // 3. 순회가 끝난 후 Queue에 남아있는 값들 중 target 값이 있을 경우 count한다.
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
        int numbers_size = sc.nextInt();
        int[] numbers = new int[numbers_size];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(solution(numbers, target));
    }

}
