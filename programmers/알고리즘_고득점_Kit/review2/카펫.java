package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 카펫 {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for (int i = 1; i <= total; i++) {

            int row = i;
            int height = total / i;

            if (row < height) continue;

            // 카펫을 보면 노란색 블록의 개수는 가로 양쪽 테두리 2개를 제외하고 세로 양쪽 테두리 2개를 제외한 개수를 곱한 것과 같다.
            if ((row - 2) * (height - 2) == yellow) {
                answer[0] = row;
                answer[1] = height;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int brown = sc.nextInt();
        int yellow = sc.nextInt();

        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

}
