package Level2;

import java.util.*;

public class 구명보트 {

    public static int solution(int[] people, int limit) {

        Arrays.sort(people); // 오름차순 정렬
        int left = 0; // 가장 가벼운 사람
        int right = people.length - 1; // 가장 무거운 사람
        int answer = 0;

        while (left <= right) {

            // 가장 가벼운 사람 + 가장 무거운 사람 태울 수 있는 경우
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            }
            // 무거운 사람 혼자 태움
            else {
                right--;
            }

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int people_size = sc.nextInt();
        int[] people = new int[people_size];

        for (int i = 0; i < people.length; i++) {
            people[i] = sc.nextInt();
        }

        int limit = sc.nextInt();

        System.out.println(solution(people, limit));

    }

}
