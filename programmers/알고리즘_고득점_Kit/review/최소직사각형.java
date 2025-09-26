package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 최소직사각형 {

    public static int solution(int[][] sizes) {
        int answer = 0;

        int bigX = 0;
        int smallY = 0;

        for (int i = 0; i < sizes.length; i++) {
            int x = Math.max(sizes[i][0], sizes[i][1]);
            int y = Math.min(sizes[i][0], sizes[i][1]);

            bigX = Math.max(x, bigX);
            smallY = Math.max(y, smallY);
        }

        answer = bigX * smallY;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[][] sizes = new int[size][2];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                sizes[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(sizes));
    }

}
