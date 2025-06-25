package review;

import java.util.*;

public class 같은_숫자는_싫어 {

    public static int[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }

        int[] answer = new int[stack.size()];

        for (int i = answer.length - 1 ; i >= 0; i--) {
            answer[i] = stack.pop();
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
