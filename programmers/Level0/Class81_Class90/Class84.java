// 직사각형 넓이 구하기
package Level0.Class81_Class90;

import java.util.Scanner;

public class Class84 {

    public static int solution(int[][] dots) {

        int answer = 0;

        int max_width = dots[0][0];
        for (int i = 1; i < dots.length; i++) {
            if (dots[i][0] > max_width) {
                max_width = dots[i][0];
            }
        }

        int min_width = dots[0][0];
        for (int i = 1; i < dots.length; i++) {
            if (dots[i][0] < min_width) {
                min_width = dots[i][0];
            }
        }

        int max_height = dots[0][1];
        for (int i = 1; i < dots.length; i++) {
            if (dots[i][1] > max_height) {
                max_height = dots[i][1];
            }
        }

        int min_height = dots[0][1];
        for (int i = 1; i < dots.length; i++) {
            if (dots[i][1] < min_height) {
                min_height = dots[i][1];
            }
        }

        int width = Math.abs(max_width - min_width);
        int height = Math.abs(max_height - min_height);

        answer = width * height;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] dots = new int[4][2];

        for (int i = 0; i < dots.length; i++) {
            for (int j = 0; j < dots[i].length; j++) {
                dots[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(dots));
    }
}