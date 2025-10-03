package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 같은_숫자는_싫어 {

    public static int[] solution(int []arr) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (stack.isEmpty()) {
                stack.add(num);
            }
            else if (stack.peek() != num) {
                stack.add(num);
            }
        }

        answer = new int[stack.size()];
        int index = 0;
        for (int num : stack) {
            answer[index++] = num;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(arr)));
    }

}
