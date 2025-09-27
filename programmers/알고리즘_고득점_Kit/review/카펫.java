package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 카펫 {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;

        for (int i = 1; i <= brown + yellow; i++) {
            if (sum % i == 0) {

                int width = i;
                int height = sum / i;

                if (width < height) continue;

                // 위, 아래 갈색 테두리에서 각각 블록 하나씩을 빼자
                // 왼쪽, 오른쪽 갈색 테두리에서 각각 블록 하나씩을 빼자
                if ((width-2) * (height-2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                }
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
