package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 더_맵게 {

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 오름차순

        for (int num : scoville) {
            heap.add(num);
        }

        while(heap.size() >= 2 && heap.peek() < K) {
            int firstPoll = heap.poll();
            int secondPoll = heap.poll();

            int newSco = firstPoll + (secondPoll * 2);

            heap.add(newSco);
            answer++;
        }

        // 힙에 남은 원소가 K 미만일 경우 while문을 계속 돌려야하는데 한 개밖에 없으므로
        // -1을 리턴해야 한다.
        if (heap.size() == 1 && heap.peek() < K) {
            answer = -1;
            return answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] scoville = new int[size];

        for (int i = 0; i < scoville.length; i++) {
            scoville[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        System.out.println(solution(scoville, K));

    }

}
