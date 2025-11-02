package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 게임_맵_최단거리 {

    public static int solution(int[][] maps) {

        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];

        int[] moveX = {-1, 1, 0, 0}; // 좌우상하
        int[] moveY = {0, 0, 1, -1}; // 좌우상하

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = 1;

        while(!queue.isEmpty()) {

            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dx = poll[0] + moveX[i];
                int dy = poll[1] + moveY[i];

                if ((dx >= 0 && dx < maps.length) && (dy >= 0 && dy < maps[0].length)) {
                    if (visited[dx][dy] == 0 && maps[dx][dy] == 1) {
                        visited[dx][dy] = visited[poll[0]][poll[1]] + 1;
                        queue.add(new int[]{dx, dy});
                    }
                }
            }
        }

        if (visited[maps.length-1][maps[0].length-1] == 0) {
            answer = -1;
            return answer;
        }
        else {
            answer = visited[maps.length-1][maps[0].length-1];
            return answer;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] maps = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(maps));
    }

}
