// 스택(LIFO)
package 알고리즘_고득점_Kit.스택_큐;

import java.util.*;

public class 같은_숫자는_싫어 {

    public static int[] solution(int []arr) {

        // 1. 중복 없이 값을 넣는 스택(LIFO 구조) 선언
        Stack<Integer> stack = new Stack<>();

        /**
         * 2. 스택에 값을 넣을 때
         * 마지막으로 넣은 값이 넣으려고 하는 값과 동일할 때 넣지 않거나 스택이 비어있을 경우 값을 넣는다.
         */
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num)
                stack.push(num);
        }

        // 3. 스택의 남은 수들을 반환할 배열 선언
        // 배열의 크기는 스택의 크기와 동일하다.
        int[] answer = new int[stack.size()];

        // 4. 스택의 pop을 통해 마지막 인덱스부터 배열에 저장 후 return
        for (int i = answer.length - 1; i >= 0; i --) {
            answer[i] = stack.pop();
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

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
