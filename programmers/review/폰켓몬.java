package review;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 폰켓몬 {

    public static int solution(int[] nums) {

        int answer = 0;
        int max = nums.length / 2; // nums 배열의 길이는 항상 짝수로 주어진다.

        // 1. 값의 중복을 제거하기 위해 HashSet 선언
        Set<Integer> set = new HashSet<>();

        // 2. nums의 배열 값 HashSet 저장
        for (int num : nums) {
            set.add(num);
        }

        // 3. HashSet의 크기가 max보다 크거나 같으면 max 반환
        if (set.size() >= max) {
            return max;
        }
        else { // 4. HashSet의 크기가 max보다 작으면 HashSet 크기 반환
            return set.size();
        }


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] num = new int[N];

        for (int i = 0; i<N; i++) {
            num[i] = sc.nextInt();
        }

        System.out.println(solution(num));

    }
}
