package Level2;

import java.util.*;

public class 타겟_넘버 {

    static int count = 0;

    public static int solution(int[] numbers, int target) {
        int result = 0; // 순차적으로 쌓여가는 결과 값
        int index = 0; // 다음 계산해야 할 numbers의 인덱스

        dfs(numbers, result, index, target);

        return count;
    }

    public static void dfs(int[] numbers, int result, int index, int target) {

        // 끝까지 수행해야 하므로 index가 numbers 배열의 길이와 같을 경우 끝낸다.
        if (index == numbers.length) {
            if (result == target) { // 이때, 결과 값이 target과 같을 경우 반환해야 할 count를 증가
                count++;
            }
            return;
        }

        dfs(numbers, result - numbers[index], index + 1, target); // 해당 인덱스 값을 뺄 때
        dfs(numbers, result + numbers[index], index + 1, target); // 해당 인덱스 값을 더할 때
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(solution(numbers, target));
    }


}
