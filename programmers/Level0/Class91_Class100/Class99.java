// 평행
package Level0.Class91_Class100;

import java.util.Scanner;

public class Class99 {

    // 네 점 중 두 점을 선택해 직선을 만들고, 나머지 두 점으로 하나의 직선을 만든다.
    // 두 직선의 기울기를 비교해 기울기가 같으면 평행한 것으로 간주한다.
    public static int solution(int[][] dots) {
        int answer = 0;

        int x1 = dots[0][0], y1 = dots[0][1];
        int x2 = dots[1][0], y2 = dots[1][1];
        int x3 = dots[2][0], y3 = dots[2][1];
        int x4 = dots[3][0], y4 = dots[3][1];
        

        double gradient1 = (double) (y2 - y1) / (x2 - x1);
        double gradient2 = (double) (y4 - y3) / (x4 - x3);
        if (gradient1 == gradient2) answer = 1;

        gradient1 = (double) (y3 - y1) / (x3 - x1);
        gradient2 = (double) (y2 - y4) / (x2 - x4);
        if (gradient1 == gradient2) answer = 1;

        gradient1 = (double) (y4 - y1) / (x4 - x1);
        gradient2 = (double) (y2 - y3) / (x2 - x3);
        if (gradient1 == gradient2) answer = 1;

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
