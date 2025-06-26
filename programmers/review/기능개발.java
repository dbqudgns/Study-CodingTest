package review;

import java.util.*;

public class 기능개발 {

    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> que = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int day = (int) Math.ceil(remain);

            if (!que.isEmpty() && que.peek() < day) {
                answer.add(que.size());
                que.clear();
            }

            que.add(day);

        }

        answer.add(que.size());

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
