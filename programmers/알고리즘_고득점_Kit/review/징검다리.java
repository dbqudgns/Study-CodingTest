package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 징검다리 {

    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks); // 이분탐색을 위해 정렬 필수

        int low = 0; // 시작지점
        int high = distance; // 도착지점

        while (low <= high) {

            /**
             * mid : 징검다리 내 시작, 끝지점, 돌맹이들 사이 간격의 최소 거리
             * 모든 바위 사이의 간격이 최소 mid 이상이어야 한다.
             */
            int mid = (low + high) / 2;

            /**
             * 지운 돌맹이들이 원래 지워야 할 돌맹이(n)보다 같거나 작다면 ?
             * 지워지는 돌맹이들이 더 많아야 하므로 mid를 키워야 한다.
             */
            if (getRemove(rocks, distance, mid) <= n) {
                answer = mid;
                low = mid + 1;
            }
            /**
             * 지운 돌맹이들이 원래 지워야 할 돌맹이(n)보다 크다면 ?
             * 지워지는 돌맹이들이 작아야 하므로 mid를 줄여야 한다.
             */
            else {
                high = mid - 1;
            }
        }

        return answer;
    }

    // 최소 거리(mid) 기준으로 지워야 할 돌맹이 개수를 세는 메서드
    private static int getRemove(int[] rocks, int distance, int mid) {
        int before = 0;
        int remove = 0;
        int end = distance;

        // 이 반복문은 rocks 배열에 있는 바위들만 검사한다.
        for (int i = 0; i < rocks.length; i++) {
            // mid보다 간격이 작은 경우 돌맹이를 제거한다.
            // 제거 이유 : mid는 최소 거리다. 즉, 지점과 돌맹이들 간의 거리가 최소 거리인 mid보다 커야 한다.
            if (rocks[i] - before < mid) {
                remove++;
                continue;
            }
            before = rocks[i];
        }

        // 도착지점(end)과 마지막 바위 사이의 거리도 징검다리 간격 중 하나이므로
        // 도착지점 - 이전 지점 값이 mid 값보다 작을 경우(최소 거리일 경우) 제거해야 한다.
        if (end - before < mid) remove++;

        return remove;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int distance = sc.nextInt();
        int rocksSize = sc.nextInt();
        int[] rocks = new int[rocksSize];

        for (int i = 0; i < rocks.length; i++) {
            rocks[i] = sc.nextInt();
        }

        int n = sc.nextInt();

        System.out.println(solution(distance, rocks, n));
    }

}
