package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 구명보트 {

    public static int solution(int[] people, int limit) {

        Arrays.sort(people);
        int left = 0; // 가장 가벼운 사람
        int right = people.length - 1; // 가장 무거운 사람
        int answer = 0;

        while (left <= right) {

            // 가장 가벼운 사람 + 가장 무거운 사람을 구명보트에 태울 수 있는 경우
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                answer++;
            }
            // 현재 제일 가벼운 사람과 타도 limit를 넘으면, 무거운 사람 혼자 태움
            else { right--; answer++; }

        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] people = new int[size];
        for (int i = 0; i < size; i++) {
            people[i] = sc.nextInt();
        }

        int limit = sc.nextInt();

        System.out.println(solution(people, limit));
    }

}
