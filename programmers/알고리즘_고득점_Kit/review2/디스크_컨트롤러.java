package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 디스크_컨트롤러 {

    public static int solution(int[][] jobs) {

        // 작업 시간을 기준으로 오름차순 정렬 우선순위 큐
        // 짧은 작업 시간 먼저 처리하기 위해 사용
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // jobs 배열을 요청 시간을 기준으로 오름차순 정렬
        // 작업 요청 시간 순서대로 처리를 시작하기 위해
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int index = 0;
        int time = 0;
        int totalWaitTime = 0;

        while (count < jobs.length) {

            // 현재 시간 이전에 요청된 모든 작업을 우선순위 큐에 저장
            // 이때, 작업 시간 오름차순으로 작업이 정렬된다.
            while(index < jobs.length && jobs[index][0] <= time) {
                queue.add(jobs[index++]);
            }

            // 큐가 비어있다는 것은 현재 시간이 작업 요청 시간에 오지 않았음을 의미
            // 따라서, 현재 시간을 index 작업으로 이동
            if (queue.isEmpty()) time = jobs[index][0];
            else {
                int[] job = queue.poll();
                time += job[1]; // 작업의 소요 시간만큼 현재 시간 증가
                totalWaitTime += time - job[0];// 각 job의 대기 시간을 더한다.
                count++;
            }
        }

        return totalWaitTime / jobs.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[][] jobs = new int[size][2];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                jobs[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(jobs));
    }

}
