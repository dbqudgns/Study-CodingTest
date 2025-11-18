package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 입국심사 {

    public static long solution(int n, int[] times) {

        long answer = 0;

        // 1. times 배열을 오름차순으로 정렬한다.
        Arrays.sort(times);

        // 2. 가능한 시간 범위의 최솟값 low = 0에서 시작
        long low = 0;

        // 2. 최대 값 high = 가장 오래 걸리는 심사관의 시간 * 사람 수
        long high = (long)times[times.length - 1] * n;

        while (low <= high) {

            // 3. mid 시간 내에서 심사할 수 있는 총 인원수를 구한다.
            long mid = (low + high) / 2;

            // 4. 각 심사관이 mid 시간 동안 처리할 수 있는 사람 수를 계산한다.
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }

            // 5. sum >= n인 경우, mid 시간이 충분하거나 넘치므로 시간을 줄이기 위해 high = mid - 1로 범위를 서렁한다.
            if (sum >= n) {
                answer = mid;
                high = mid - 1;
            }
            // 6. sum < n 인 경우, 시간이 부족하므로 low = mid +1로 범위를 늘린다.
            else {
                low = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int size = sc.nextInt();
        int[] times = new int[size];

        for (int i = 0; i < 2; i++) {
            times[i] = sc.nextInt();
        }

        System.out.println(solution(n, times));
    }
}
