// 완전 탐색
package Level1;

import java.util.*;

public class 최소직사각형 {

    public static int solution(int[][] sizes) {

        int answer = 0;
        // 1. 가로가 긴 지갑이라고 가정해보자 ( 가로, 세로 둘 다 상관없음 )
        int bigX = 0;
        int smallY = 0;

        // 2. 각 명함을 순회를 한다.
        for (int[] size : sizes) {

            int max = Math.max(size[0], size[1]); // 둘 중 가장 큰 값을 고른다.
            int min = Math.min(size[0], size[1]); // 둘 중 가장 작은 값을 고른다.

            bigX = Math.max(max, bigX); // 기존 크기와 비교하여 큰 값을 갱신한다.
            smallY = Math.max(min, smallY); // 기존 크기와 비교하여 큰 값을 갱신한다.

        }

        answer = bigX * smallY;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x_size = sc.nextInt();
        int y_size = sc.nextInt();

        int[][] sizes = new int[x_size][y_size];

        for(int i = 0; i < x_size; i++) {
            for (int j = 0; j < y_size; j++) {
                sizes[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(sizes));

    }

}
