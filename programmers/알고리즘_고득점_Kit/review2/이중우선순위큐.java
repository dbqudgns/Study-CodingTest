package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 이중우선순위큐 {

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> up = new PriorityQueue<>();
        PriorityQueue<Integer> down = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {

            String[] split = operation.split(" ");

            if (operation.startsWith("I")) {
                up.add(Integer.parseInt(split[1]));
                down.add(Integer.parseInt(split[1]));
            }
            else if (split[1].equals("1")) {
                Integer poll = down.poll();
                up.remove(poll);
            }
            else {
                Integer poll = up.poll();
                down.remove(poll);
            }
        }

        if (up.isEmpty() && down.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
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
