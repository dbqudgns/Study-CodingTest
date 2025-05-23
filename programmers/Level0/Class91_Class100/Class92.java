// 최빈값 구하기
package Level0.Class91_Class100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Class92 {

    public static int solution(int[] array) {
        int answer = -1; // 최빈 값

        // 1. 자연수 키 : 빈도 수 저장할 HashMap 생성
        Map<Integer, Integer> map = new HashMap<>();

        // 2. 반복문을 통해 특정 키의 빈도수 구하기
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 3. 반복문을 통해 최빈값의 빈도 수 구하기
        int max_num = 0;
        for (int num : map.values()) {
            if (num > max_num) {
                max_num = num;
            }
        }

        // 4. max_num을 가진 키가 여러 개인지 확인 (여기서부터 도움을 받음)
        int count = 0;
        for (int value : map.values()) {
            if (value == max_num) {
                count++;
            }
        }

        // 5. count == 1인 경우는 max_num을 가진 키가 하나 밖에 없다는 뜻 => 해당 키 반환
        // count의 값이 2 이상이면 max_num을 가진 키가 여러 개 있다는 뜻 => -1 반환
        if (count == 1) {
            for (int key : map.keySet()) {
                if (map.get(key) == max_num) {
                    answer = key;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(solution(array));
    }
}
