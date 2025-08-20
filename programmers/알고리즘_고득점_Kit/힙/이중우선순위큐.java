// 힙
package 알고리즘_고득점_Kit.힙;

import java.util.*;

public class 이중우선순위큐 {

    public static int[] solution(String[] operations) {

        int[] answer = {};
        // 1. 정수 값을 저장할 오름차순, 내림차순 우선순위 큐 선언
        PriorityQueue<Integer> ascending = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> descending = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

        // 2. operations를 순회하면서 명령어와 데이터를 뽑아낸다.
        for (String oper : operations) {
            String[] split = oper.split(" ");

            // 3. 명령어를 기준으로 데이터를 우선순위 큐에 삽입/삭제
            if (split[0].equals("I")) {
                ascending.add(Integer.valueOf(split[1]));
                descending.add(Integer.valueOf(split[1]));
            }
            else if (!descending.isEmpty() && split[1].equals("1")) { // 최대값 삭제
                int maxPoll = descending.poll();
                ascending.remove(maxPoll);
            }
            else if (!ascending.isEmpty() && split[1].equals("-1")) { // 최소값 삭제
                int minPoll = ascending.poll();
                descending.remove(minPoll);
            }
        }

        // 4. 큐가 비어있다면 0,0 반환
        if (ascending.isEmpty()) {
            return new int[]{0,0};
        }
        // 5. 큐의 사이즈가 1이면 해당 값 반환
        else if (ascending.size() == 1) {
            int poll = ascending.poll();
            return new int[]{poll, poll};
        }
        // 6. 큐의 사이즈가 2이상인 경우
        else {
            return new int[]{descending.poll(), ascending.poll()};
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String[] operations = new String[size];

        sc.nextLine();

        for (int i = 0; i < size; i++) {
            operations[i] = sc.nextLine();
        }

        System.out.println(Arrays.toString(solution(operations)));

    }

}
