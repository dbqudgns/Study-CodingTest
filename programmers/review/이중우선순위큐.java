package review;

import java.util.*;

public class 이중우선순위큐 {

    public static int[] solution(String[] operations) {

        int[] answer = new int[2];
        PriorityQueue<Integer> up = new PriorityQueue<>(); // 오름차순 전용 우선순위큐
        PriorityQueue<Integer> down = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 전용 우선순위큐

        for (String operation : operations) {

            String[] context = new String[2];
            context = operation.split(" ");

            if (context[0].equals("I")) {
                up.add(Integer.parseInt(context[1]));
                down.add(Integer.parseInt(context[1]));
            }
            else if (!down.isEmpty() && context[1].equals("1")) { // 내림차순 큐에서 최대 값을 삭제
                Integer poll = down.poll();
                up.remove(poll); // 오름차순 큐에서 최대 값 삭제
            }
            else if (!up.isEmpty() && context[1].equals("-1")){ // 오름차순 큐에서 최소 값을 삭제
                Integer poll = up.poll();
                down.remove(poll); // 내림차순 큐에서 최대 값 삭제
            }

        }

        // 두 개의 우선순위큐 중 하나라도 비어 있다면 0,0을 반환
        if (up.isEmpty() || down.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else { // 두 개의 우선순위큐가 둘다 비어있지 않으면 최대값, 최소값을 반환
            answer[0] = down.poll();
            answer[1] = up.poll();
        }

        return answer;


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
