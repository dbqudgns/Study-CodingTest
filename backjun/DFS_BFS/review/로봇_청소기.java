package DFS_BFS.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇_청소기 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] map;
    static int value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];

        token = new StringTokenizer(br.readLine());

        int startX = Integer.parseInt(token.nextToken());
        int startY = Integer.parseInt(token.nextToken());
        int startDir = Integer.parseInt(token.nextToken());

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        bfs(startX, startY, startDir);
        System.out.println(value);
    }

    public static void bfs(int x, int y, int dir) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, dir});

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];
            int curDir = poll[2];

            if (map[curX][curY] == 0) {
                value++;
                map[curX][curY] = 2;
            }

            int squareDone = 0;
            int nextDir = curDir;
            for (int i = 0; i < 4; i++) {

                // 왼쪽으로 회전
                nextDir = (nextDir + 3) % 4;

                int moveX = curX + dx[nextDir];
                int moveY = curY + dy[nextDir];

                if (moveX < 0 || moveY < 0 || moveX >= N || moveY >= M) {
                    continue;
                }

                if (map[moveX][moveY] == 2 || map[moveX][moveY] == 1) {
                    squareDone++;
                    continue;
                }

                if (map[moveX][moveY] == 0) {
                    queue.add(new int[]{moveX, moveY, nextDir});
                    break;
                }
            }

            if (squareDone == 4) {
                switch(curDir) {
                    case 0 :
                        if (!visitedProceed(curX + 1, curY) && map[curX + 1][curY] != 1)
                            queue.add(new int[]{curX + 1, curY, 0});
                        break;
                    case 1 :
                        if (!visitedProceed(curX, curY - 1) && map[curX][curY - 1] != 1)
                            queue.add(new int[]{curX, curY - 1, 1});
                        break;
                    case 2 :
                        if (!visitedProceed(curX - 1, curY) && map[curX - 1][curY] != 1)
                            queue.add(new int[]{curX - 1, curY, 2});
                        break;
                    case 3 :
                        if (!visitedProceed(curX, curY + 1) && map[curX][curY + 1] != 1)
                            queue.add(new int[]{curX, curY + 1, 3});
                        break;
                }
            }
        }
    }
    public static boolean visitedProceed(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}