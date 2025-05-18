// 소인수분해
package Level0.Class71_Class80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Class73 {

    public static int[] solution(int n) {
        int[] answer = {};

        // 1. 소인수를 저장할 리스트를 생성
        List<Integer> list = new ArrayList<>();

        // 2. for문으로 2부터 n까지 각 숫자에 대한 소인수분해를 진행한다.
        for (int i = 2; i <= n; i++) {
            // 3. 조건문으로 현재 숫자로 나누어 떨어지면 소인수이다.
            if (n % i == 0) {

                // 4. while문으로 현재 숫자로 나누어 떨어지는 동안 계속 나눈다.
                while (n % i == 0) {
                    n /= i;
                }

                // 5. 나누어 떨어진 숫자를 리스트에 추가한다.
                list.add(i);

            }
        }

        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(Arrays.toString(solution(n)));
    }

}
