package D4;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 수영대회_결승전 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int startX = sc.nextInt();
            int startY = sc.nextInt();

            int endX = sc.nextInt();
            int endY = sc.nextInt();

            int value = dfs(N, map, startX, startY, endX, endY);
            System.out.println("#" + test_case + " " + value);
        }
    }

    public static int dfs(int N, int[][] map,
                          int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {startX, startY, 0});

        boolean[][] visited = new boolean[N][N];
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int time = poll[2];

            if (currentX == endX && currentY == endY) return time;

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N ||
                        map[nextX][nextY] == 1 || visited[nextX][nextY]) continue;

                if (map[nextX][nextY] == 2) {
                    if (time % 3 == 2) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, time + 1});
                    } else {
                        queue.add(new int[]{currentX, currentY, time + 1});
                    }
                } else {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, time + 1});
                }
            }
        }

        return -1;
    }
}