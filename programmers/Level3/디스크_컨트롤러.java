// 힙
package Level3;

import java.util.*;

public class 디스크_컨트롤러 {

    public static int solution(int[][] jobs) {

        // 1. 작업 시간을 기준으로 오름차순 정렬하는 우선순위 큐 선언 및 초기화
        // 우선순위 큐는 짧은 작업을 먼저 처리하기 위해 사용됨
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // 2. jobs 배열을 요청 시간을 기준으로 오름차순 정렬
        // 이는 작업 요청 시간 순서대로 처리를 시작하기 위한 사전 준비
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        int count = 0; // 처리된 작업의 수 카운트
        int index = 0; // 현재 처리할 작업의 인덱스
        int time = 0; // 현재 시간을 나타내며 작업이 처리되는 시간 추적
        int totalWaitTime = 0; // 모든 작업의 대기 시간

        // 3. 모든 작업이 처리될 때까지 반복문 수행한다.
        while (count < jobs.length) {

            // 4. 현재 시간 이전에 요청된 모든 작업을 우선순위 큐에 추가
            while (index < jobs.length && jobs[index][0] <= time) {
                queue.add(jobs[index++]);
            }

            // 5. 큐가 비어 있다면, 현재 처리할 작업이 없으니 다음 작업의 요청 시간으로 시간을 이동
            if (queue.isEmpty()) time = jobs[index][0];
            else { // 6. 하드디스크에서 작업 수행
                int[] job = queue.poll();

                time += job[1]; // 작업의 소요 시간만큼 현재 시간을 증가시킨다.

                totalWaitTime += time - job[0]; // 각 job의 대기 시간을 더한다.

                count++; // 처리된 작업 수를 증가
            }
        }

        // 7. 모든 작업의 대기 시간 총합을 작업 수로 나누어 평균 대기 시간을 계산 후 반환
        return totalWaitTime / jobs.length;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int[][] jobs = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                jobs[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(jobs));
    }

}
