package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 게임_맵_최단거리 {

    public static int solution(int[][] maps) {

        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);

        int answer = visited[maps.length - 1][maps[0].length - 1];
        if (answer == 0)
            return -1;

        return answer;

    }

    public static void bfs(int[][] maps, int[][] visited) {

        int[] dx = {1, -1, 0, 0}; // 상하좌우
        int[] dy = {0, 0, -1, 1}; // 상하좌우

        int x = 0;
        int y = 0;
        visited[x][y] = 1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cX = current[0];
            int cY = current[1];

            for (int i = 0; i < 4; i++) {
                int X = cX + dx[i];
                int Y = cY + dy[i];

                if ( X < 0 || Y < 0 || X >= maps.length || Y >= maps[0].length) {
                    continue;
                }

                if (visited[X][Y] == 0 && maps[X][Y] == 1) {
                    visited[X][Y] = visited[cX][cY] + 1;
                    queue.add(new int[]{X, Y});
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maps = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(maps));
    }
}
