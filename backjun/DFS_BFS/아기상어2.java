package DFS_BFS;

import java.util.*;
import java.io.*;

public class 아기상어2 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;
    static int[] mx = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상,하,좌,우,위왼대,위오대,아왼대,아오대
    static int[] my = {0, 0, -1, 1, -1, 1, -1, 1}; // 상,하,좌,우,위왼대,위오대,아왼대,아오대

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];
                answer = Math.max(answer, bfs(i, j));
            }
        }

        System.out.println(answer);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});

        int value = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {

            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int count = poll[2];

            if (map[currentX][currentY] == 1) {
                value = Math.min(value, count);
            }

            for (int i = 0; i < 8; i++) {
                int nextX = currentX + mx[i];
                int nextY = currentY + my[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, count+1});
                }
            }
        }
        return value;
    }

}
