// 완전 탐색
package 알고리즘_고득점_Kit.완전탐색;

import java.util.*;

public class 카펫 {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        // 1. total(brown+yellow)의 약수를 구한다.
        for (int i = 1; i <= total; i++) {
            if (total % i == 0) {

                int row = i; // 가로
                int height = total / i; // 세로

                // 2. 가로보다 세로의 길이가 클 경우 반복문을 다시 진행한다.
                if ( row < height ) continue;

                // 3. 내부에 준재하는 노란색 블록의 개수[ (row - 2) * (height-2) ]와 주어진 yellow 블록의 개수가 일치하는지 판단
                if ((row - 2) * (height-2) == yellow ) {
                    answer[0] = row;
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
