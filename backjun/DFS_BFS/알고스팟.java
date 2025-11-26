package DFS_BFS;

import java.util.*;
import java.io.*;

public class 알고스팟 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        map = new int[N+1][M+1];
        for (int i = 1; i < N+1; i++) {
            String str = br.readLine();
            for (int j = 1; j < M+1; j++) {
                map[i][j] = str.charAt(j-1) - '0';
            }
        }

        bfs();
    }

    public static void bfs() {
        visited = new boolean[N+1][M+1];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1, 1, 0}); // x, y, 벽 개수
        visited[1][1] = true;

        while(!queue.isEmpty()) {

            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int count = poll[2];

            if (x == N && y == M) {
                answer = Math.min(answer, count);
            }

            for (int i = 0; i < 4; i++) {

                int dx = x + mx[i];
                int dy = y + my[i];

                if (dx > 0 && dy > 0 && dx <= N && dy <= M) {

                    if (!visited[dx][dy]) {
                        // 벽이라면
                        if (map[dx][dy] == 1) {
                            visited[dx][dy] = true;
                            queue.add(new int[]{dx, dy, count + 1});
                        }
                        // 방이라면
                        else {
                            visited[dx][dy] = true;
                            queue.add(new int[]{dx, dy, count});
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
