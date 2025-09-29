package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 폰켓몬 {

    public static int solution(int[] nums) {
        Set<Integer> hashset = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hashset.add(nums[i]);
        }

        if (nums.length / 2 < hashset.size()) return nums.length / 2;
        else return hashset.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(solution(nums));
    }

}
