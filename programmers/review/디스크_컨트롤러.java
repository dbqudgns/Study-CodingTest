package review;

import java.util.*;

// 객체 지향적으로 풀어보자
public class 디스크_컨트롤러 {

    static class Job {
        int i; // 번호
        int t; // 요청 시각
        int w; // 소요 시각

        public Job (int i, int t, int w) {
            this.i = i;
            this.t = t;
            this.w = w;
        }
    }

    static class Disk {
        int iter; // 작업 도는 지시자
        int amount_work_time; // 일 수행 시간 총량
        int done_cnt; // 끝낸 일 수
        int end; // 현재 시점(디스크가 놀지 않고 일한 시간 기준)

        public Disk() {
            this.iter = 0;
            this.amount_work_time = 0;
            this.done_cnt = 0;
            this.end = 0;
        }
    }

    public static int solution(int[][] jobs) {

        // 1. Job에 대한 우선순위 큐 만들기
        PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2) -> {
            if (j1.t == j2.t && j1.w == j2.w) return j1.i - j2.i; // 번호 오름차순
            if (j1.w == j2.w) return j1.t - j2.t; // 요청 시각 오름차순
            return j1.w - j2.w; // 소요 시각 오름차순
        });

        // 2. jobs 배열을 요청 시각(t) 기준으로 오름차순 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 3. 일을 처리하는 디스크 객체 생성 및 선언
        Disk disk = new Disk();

        // 4. 디스크가 끝낸 일 수가 모든 일의 개수가 될 때까지 다음 반복문을 수행한다.
        while(disk.done_cnt < jobs.length) {

            // 4.1 현재 시점(disk.end)까지 들어온 Job들을 모두 큐에 넣는다.
            while(disk.iter < jobs.length && disk.end >= jobs[disk.iter][0]) {
                pq.add(new Job(disk.iter, jobs[disk.iter][0], jobs[disk.iter][1]));
                disk.iter++;
            }

            // 4.2 큐가 비어있을 때, 다음 요청 시점(jobs[disk.iter][0])으로 시간을 이동시킨다.
            if (pq.isEmpty()) {
                if (disk.iter < jobs.length) disk.end = jobs[disk.iter][0];
            }
            // 4.3 작업 처리
            else {
                Job now = pq.poll();
                // 디스크가 작업을 시작한 시점 : disk.end
                // 해당 작업의 응답 시간 = 디스크가 작업을 시작한 시점 + 소요 시각 - 요청 시각
                // += 연산을 통해 누적한다.
                disk.amount_work_time += disk.end + now.w - now.t;
                // 디스크가 작업을 요청한 시점에 소요 시각을 더하면 현재 시점으로 이동한다.
                disk.end += now.w;
                disk.done_cnt++;
            }
        }

        return disk.amount_work_time/jobs.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int jobs_size = sc.nextInt();

        int[][] jobs = new int[jobs_size][2];

        for (int i = 0; i < jobs_size; i++) {
            for (int j = 0; j < 2; j++) {
                jobs[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(jobs));

    }

}
