// 공 던지기
package Level0.Class71_Class80;

import java.util.Scanner;

public class Class76 {

    public static int solution(int[] numbers, int k) {
        int answer = 0;
        int index = 0;

        // k번째 공을 던진 사람을 구하기 위한 반복문
        for (int i = 1; i < k; i++) {
            index += 2;
        }

        // 0 -> 2
        // 2 -> 4
        // 4 -> 6
        // 6 -> 8

        // index를 배열 길이로 나머지 연산을 수행하여 배열의 범위 안으로 index를 조정
        index = index % numbers.length;
        answer = numbers[index];

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        System.out.println(solution(numbers, k));
    }
}
