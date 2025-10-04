package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 기능개발 {

    public static int[] solution(int[] progresses, int[] speeds) {
        int size = progresses.length;
        int[] remain = new int[size];
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < size; i++) {
            int remainPercent = 100 - progresses[i];
            int remainDay = remainPercent % speeds[i];

            if (remainDay == 0) remain[i] = remainPercent / speeds[i];
            else remain[i] = remainPercent / speeds[i] + 1;
        }

        for (int day : remain) {
            if (queue.isEmpty() || queue.peek() >= day) {
                queue.add(day);
            }
            else {
                list.add(queue.size());
                queue.clear();
                queue.add(day);
            }
        }

        if (!queue.isEmpty()) list.add(queue.size());

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] progresses = new int[size];
        int[] speeds = new int[size];

        for(int i = 0; i < size; i++) {
            progresses[i] = sc.nextInt();
        }

        for (int i = 0; i < size; i++) {
            speeds[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
}
