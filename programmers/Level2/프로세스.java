// 큐
package Level2;

import java.util.*;

public class 프로세스 {

    static class Process {

        private int priority;
        private int index;

        public Process(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }

        public int getPriority() {
            return priority;
        }

        public int getIndex() {
            return index;
        }
    }

    public static int solution(int[] priorities, int location) {

        // 1. 프로세스들을 담을 큐 선언
        Queue<Process> queue = new ArrayDeque<>();
        int answer = 0;

        // 2. 큐에 우선순위와 인덱스 값을 담을 프로세스 넣기
        for (int i = 0; i < priorities.length; i++) {
            Process process = new Process(priorities[i], i);
            queue.add(process);
        }

        // 3. 큐에 다시 값을 넣는 경우를 생각하여 while 반복문을 사용한다.
        while(true) {

            Process poll = queue.poll(); // 3.1 첫 번째 프로세스를 꺼낸다.

            boolean higer = false;
            for (Process p : queue) { // 3.2 큐에 남아있는 프로세스들과 꺼낸 프로세스의 우선순위를 비교한다.
                if (p.getPriority() > poll.getPriority()) {
                    higer = true;
                    break;
                }
            }

            if (higer) queue.add(poll); // 3.3 꺼낸 프로세스보다 우선순위가 높은 프로세스가 있을 경우 꺼낸 프로세스를 다시 넣는다.
            else { // 3.4 꺼낸 프로세스보다 우선순위가 높은 프로세스가 없는 경우 answer 값을 증가시킨다.
                answer++;
                if (poll.getIndex() == location) return answer; // 3.5 꺼낸 프로세스의 인덱스와 찾고자 하는 location 값이 일치할 경우 answer을 반환한다.
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
