package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 더_맵게 {

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : scoville) {
            pq.add(num);
        }

        while(pq.peek() < K && pq.size() >= 2) {

            int first = pq.poll();
            int second = pq.poll();

            int next = first + (second * 2);
            pq.add(next);

            answer++;
        }

        if (pq.peek() < K) {
            return -1;
        }

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] scovile = new int[size];

        for (int i = 0; i < size; i++) {
            scovile[i] = sc.nextInt();
        }

        int K = sc.nextInt();
        System.out.println(solution(scovile, K));
    }
}
