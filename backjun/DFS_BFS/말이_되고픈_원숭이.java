package DFS_BFS;

import java.util.*;
import java.io.*;

public class 말이_되고픈_원숭이 {

    static int K;
    static int M, H;
    static int[][] map;
    static boolean[][][] visited; // 좌표 (x, y)를 도착했을 때, 말 이동을 k번 사용한 상태로 방문했는가?
    static int answer = 0;

    // 동 서 남 북
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    // 체스 말 기준
    static int[][] horse = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2},
                     {1, -2}, {2, -1}, {1, 2}, {2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());
        M = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());

        map = new int[H][M];
        visited = new boolean[H][M][K+1]; // 말 사용횟수도 담는다.

        for (int i = 0; i < H; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        bfs(0, 0);

        System.out.println(answer);
    }

    public static void bfs(int x, int y) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, 0, 0}); // x, y, 이동 횟수, 말사용 횟수
        visited[x][y][0] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];
            int cnt = poll[2];
            int horseCnt = poll[3];

            if (curX == H-1 && curY == M-1) {
                answer = cnt;
                return;
            }

            // 한 칸이동
            for (int i = 0; i < 4; i++) {
                int movX = curX + dx[i];
                int movY = curY + dy[i];

                if (movX < 0 || movY < 0 || movX >= H || movY >= M) continue;

                if (map[movX][movY] != 1 && !visited[movX][movY][horseCnt]) {
                    queue.add(new int[]{movX, movY, cnt + 1, horseCnt});
                    visited[movX][movY][horseCnt] = true;
                }
            }

            // 말 이동
            if (horseCnt <  K) {
                for (int i = 0; i < 8; i++) {
                    int movX = curX + horse[i][0];
                    int movY = curY + horse[i][1];

                    if (movX < 0 || movY < 0 || movX >= H || movY >= M) continue;

                    if (map[movX][movY] != 1 && !visited[movX][movY][horseCnt + 1]) {
                        queue.add(new int[]{movX, movY, cnt + 1, horseCnt + 1});
                        visited[movX][movY][horseCnt + 1] = true;
                    }
                }
            }
        }
        if (answer == 0) answer = -1;
    }
}
