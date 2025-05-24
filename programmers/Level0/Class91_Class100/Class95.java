// 다음에 올 숫자
package Level0.Class91_Class100;

import java.util.Arrays;
import java.util.Scanner;

public class Class95 {

    public static int[] solution(int num, int total) {
        int[] answer = new int[num]; // 연속된 수의 값 저장 배열

        int a = 0; // 첫 번째 숫자
        int temp = 0; // 1부터 num-1까지 더한 값

        // 1. 1부터 num-1까지 더한 값 temp에 저장
        for (int i = 0; i < num; i++) {
            temp += i;
        }

        // 2. total에서 temp을 뺀 값을 result 변수에 저장 및 생성
        int result = total - temp;

        // 3. result에서 num을 나눈 몫을 a에 저장
        a = result / num;

        // 4. a를 시작으로 하여 num만큼 연속된 값을 answer에 저장
        int count = 0;
        while (count < num) {
            answer[count++] = a++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int total = sc.nextInt();
        System.out.println(Arrays.toString(solution(num, total)));
    }
}
