// 큐
package 알고리즘_고득점_Kit.스택_큐;

import java.util.*;

public class 기능개발 {

    public static int[] solution(int[] progresses, int[] speeds) {

        // 1. 각 기능당 소요되는 작업일을 저장하는 Queue 선언
        Queue<Integer> que = new LinkedList<>();
        List<Integer> workDay = new ArrayList<>(); // 각 기능당 소요되는 작업일
        List<Integer> answer = new ArrayList<>(); // 작업일 당 배포되는 기능 수

        // 2. 작업일 구하는 공식에 따라 작업일을 구한다.
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] >= 1) {
                workDay.add((100 - progresses[i]) / speeds[i] + 1);
            }
            else {
                workDay.add((100 - progresses[i]) / speeds[i]);
            }
        }

        // 3. 작업일을 Queue에 넣을 때 다음 규칙을 따른다.
        for (Integer day : workDay) {

            // Queue가 비어있거나 넣을 값이 첫 번째 값보다 작거나 같은 경우 Queue에 담는다.
            if (que.isEmpty() || que.peek() >= day)
                que.add(day);

            // 넣을 값이 첫 번째 값보다 클 경우 Queue에 있는 모든 값을 카운트하여 리스트에 담고 넣을 값을 Queue에 넣는다.
            else if (que.peek() < day) {
                int count = que.size();
                que.clear();
                que.add(day);
                answer.add(count);
            }

        }

        // 4. Queue에 남은 값을 카운트하여 리스트에 추가한다.
        if (!que.isEmpty()) {
            int count = que.size();
            que.clear();
            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] progresses = new int[size];
        int[] speeds = new int[size];

        for (int i = 0; i < progresses.length; i++) {
            progresses[i] = sc.nextInt();
        }

        for (int i = 0; i < speeds.length; i++) {
            speeds[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

}
