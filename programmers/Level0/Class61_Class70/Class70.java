// 7의 개수
package Level0.Class61_Class70;

import java.util.Scanner;

public class Class70 {

    public static int solution(int[] array) {
        int answer = 0;

        // 1. array 내 숫자를 1의 자리부터 확인
        for (int num : array) {
            while (num > 0) { // 2. 숫자가 0이 될 때 까지 반복
                if ( num % 10 == 7) answer++; // 3. 일의 자리가 7이면 answer 증가
                num /= 10; // 4. 다음 자리 확인
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(solution(array));
    }

}
