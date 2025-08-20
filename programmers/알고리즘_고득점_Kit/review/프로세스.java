package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 프로세스 {

    static class Process {

        int priority;
        int index;

        public Process(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public static int solution(int[] priorities, int location) {

        Queue<Process> queue = new ArrayDeque<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            Process process = new Process(priorities[i], i);
            queue.add(process);
            priorityQueue.add(priorities[i]);
        }

        int answer = 0;
        while(true) {

            Process process = queue.poll();
            Integer num = priorityQueue.poll();

            if (process.priority == num) {

                if (process.index == location) {
                    return ++answer;
                }
                else answer++;

            } else {
                priorityQueue.add(num);
                queue.add(process);
            }

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] priorities = new int[size];

        for (int i = 0; i < size; i++) {
            priorities[i] = sc.nextInt();
        }

        int location = sc.nextInt();

        System.out.println(solution(priorities, location));

    }

}
