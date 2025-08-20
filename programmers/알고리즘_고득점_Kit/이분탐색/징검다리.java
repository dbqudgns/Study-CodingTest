package 알고리즘_고득점_Kit.이분탐색;

import java.util.*;

public class 징검다리 {

    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks); // 이분탐색을 위해 정렬 필수

        int low = 0;
        int high = distance;

        while(low <= high) {

            // mid : 징검다리 내 시작,끝지점/돌맹이들 사이의 간격의 최소 거리
            // 모든 바위 사이의 간격이 최소 mid 이상되어야 한다.
            int mid = (low + high) / 2;

            if (getCnt(rocks, distance, mid) <= n) {
                answer = mid;
                // 지운 돌맹이들(getCnt() 값)이 원래 지워야 할 돌맹이(n)보다 적다면?
                // mid를 키워야 한다. => 그래야 지워지는 돌맹이들이 많아진다.
                // 문제에서 "바위를 n개 제거한 뒤 각 지점 사이의 거리의 최솟값 중에 가장 큰 값"을 구하라 했으므로
                low = mid + 1;
            }
            else {
                // 지운 돌맹이들(getCnt() 값)이 원래 지워야 할 돌맹이보다 크다면?
                // mid를 줄여야 한다. => 그래야 지워지는 돌맹이들이 작아진다.
                high = mid - 1;
            }

        }

        return answer;
    }

    private static int getCnt(int[] rocks, int distance, int mid) {
        int before = 0;
        int remove = 0;
        int end = distance;

        // 위 반복문은 rocks 배열에 있는 바위들만 검사한다.
        for (int i = 0; i < rocks.length; i++) { // mid보다 간격이 작은 경우 돌맹이를 제거한다.
            if (rocks[i] - before < mid) {
                remove++;
                continue;
            }
            before = rocks[i];
        }

        // 도착지점(end)과 마지막 바위 사이의 거리도 징검다리 간격 중 하나이므로
        // 시작지점 - 도착지점 값이 mid 값보다 작을 경우(최소 거리일 경우) 제거해야 한다.
        if (end - before < mid) {
            remove++;
        }

        return remove;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int distance = sc.nextInt();

        int rocks_size = sc.nextInt();
        int[] rocks = new int[rocks_size];

        for (int i = 0; i < rocks_size; i++) {
            rocks[i] = sc.nextInt();
        }

        int n = sc.nextInt();

        System.out.println(solution(distance, rocks, n));


    }

}
