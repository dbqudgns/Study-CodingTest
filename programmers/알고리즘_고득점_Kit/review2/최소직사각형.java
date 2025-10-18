package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 최소직사각형 {

    public static int solution(int[][] sizes) {
        int x = 0, y = 0;

        for (int[] size : sizes) {
            x = Math.max(x, Math.max(size[0], size[1]));
            y = Math.max(y, Math.min(size[0], size[1]));
        }

        return x * y;
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
