// 해시
package 알고리즘_고득점_Kit.해시;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 폰켓몬 {

    public static int solution(int[] nums) {
        int answer = 0;
        int max = nums.length / 2;

        // 1. 값의 중복을 제거하기 위해 HashSet 선언
        Set<Integer> set = new HashSet<>();

        // 2. 반복문을 통해 HashSet에 add 진행
        for (int num : nums) {
            set.add(num);
        }

        // 3. HashSet의 크기가 N/2(max) 보다 크거나 같을 때 N/2(max)를 반환
        if (set.size() >= max) {
            answer = max;
        }
        // 4. HashSet의 크기가 N/2(max) 보다 작을 때 HashSet의 크기를 반환
        else answer = set.size();

        return answer;
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
