// 큐
package 알고리즘_고득점_Kit.스택_큐;

import java.util.*;

public class 주식가격 {

    public static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        // 1.prices 값을 저장할 큐 선언
        Queue<Integer> queue = new ArrayDeque<>();

        // 2. prices 값들을 큐에 저장
        for (int price : prices) {
            queue.add(price);
        }

        int index = 0;
        // 3. 큐가 비어 있을 때까지 while문 수행
        while(!queue.isEmpty()) {

            int poll = queue.poll();
            int count = 0;

            // 4. 큐에 남아 있는 값들을 순회한다.
            for (int nextValue : queue) {
                if (poll <= nextValue) { // 5. poll 값이 큐에 있는 값보다 작을 경우 count 증가
                    count++;
                }
                else { // 6. poll 값이 큐에 있는 값보다 클 경우 count 증가 후 break;
                    count++;
                    break;
                }
            }

            answer[index++] = count;

        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));

        int size = sc.nextInt();
        int[] prices = new int[size];

        for (int i = 0; i < size; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(prices)));
    }


}
