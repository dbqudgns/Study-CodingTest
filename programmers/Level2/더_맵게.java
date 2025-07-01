// 힙
package Level2;

import java.util.*;

public class 더_맵게 {

    public static int solution(int[] scoville, int K) {

        // 1. 우선순위 큐를 이용해 최소 힙(오름 차순) 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        // 2. for문을 통해 우선순위 큐에 값을 저장
        for (int num : scoville) {
            pq.add(num);
        }

        // 3. while문을 통해 기준 값과 다음 값을 우선순위 큐에서 뽑는다.
        while(true) {

            // 만약 우선순위 큐의 길이가 1일 경우
            if (pq.size() < 2) {
                // 해당 값이 K 이상일 경우
                if (pq.poll() >= K) {
                    break;
                }
                // 해당 값이 K 이하일 경우
                else {
                    answer = -1;
                    break;
                }
            }

            int a = pq.poll();
            int b = pq.poll();

            // 이때 뽑은 두 값이 0인 경우
            if (a == 0 && b == 0) {
                answer = -1;
                break;
            }

            // 이때 뽑은 제일 작은 값이 K 이상일 경우
            if (a >= K) {
                break;
            }

            // 섞은 음식의 스코빌 지수를 구한 후 우선순위 큐에 넣는다.
            pq.add(a + (b*2));
            answer++;

        }

        return answer;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] scoville = new int[size];

        for (int i = 0; i < size; i++) {
            scoville[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        System.out.println(solution(scoville, K));

    }

}
