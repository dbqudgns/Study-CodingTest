package 알고리즘_고득점_Kit.review2;
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
        int answer = 0;
        Queue<Process> queue = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            Process process = new Process(priorities[i], i);
            queue.add(process);
        }

        while(true) {

            Process pollProcess = queue.poll();

            boolean isHigher = false;
            for (Process p : queue) {
                if (p.priority > pollProcess.priority) {
                    isHigher = true;
                    break;
                }
            }

            if (isHigher) queue.add(pollProcess);
            else {
                answer++;
                if (pollProcess.index == location) return answer;
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
