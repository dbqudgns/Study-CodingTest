package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범_검거 {

    static int N, M;
    static int startX, startY;
    static int[][] map;
    static boolean[][] visited; // 무한 반복 방지용
    static boolean[][] mark; // 시간 기준 지나갈 수 있는 터널 표시
    static int standard;

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우

    static int[][] pipe = {
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0},
            {1, 0, 1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer token;
        for (int i = 1; i <= tc; i++) {

            int answer = 0;

            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            mark = new boolean[N][M];

            startX = Integer.parseInt(token.nextToken());
            startY = Integer.parseInt(token.nextToken());

            standard = Integer.parseInt(token.nextToken());

            for (int x = 0; x < N; x++) {
                token = new StringTokenizer(br.readLine());
                for (int y = 0; y < M; y++) {
                    map[x][y] = Integer.parseInt(token.nextToken());
                }
            }

            visited[startX][startY] = true;

            long startTime = System.currentTimeMillis();
            // dfs(startX, startY,1);
            bfs(startX, startY, 1);
            long endTime = System.currentTimeMillis();

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (mark[x][y]) answer++;
                }
            }

            System.out.println("#" + i + " " + answer + "(실행 시간 : " + (endTime - startTime) + "ms)");
        }
    }

    public static void dfs(int x, int y, int depth) {

        mark[x][y] = true;

        // 기저 조건 : 시간 달성 시 백
        if (depth == standard) {
            return;
        }

        // 수행
        int curTerminal = map[x][y];
        for (int i = 0; i < 4; i++) {

            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // 범위 유효성 체크 및 다음 칸에 터널이 존재하는지 확인
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M ||
                map[nextX][nextY] == 0) continue;

            if (!visited[nextX][nextY]) {

                // 현재 터널과 다음 터널이 연결되어 있는지 확인
                int nextTerminal = map[nextX][nextY];
                if (pipe[curTerminal - 1][i] != 1) {
                    continue;
                }

                boolean isContinue = false;
                if (i == 0) {
                    if (pipe[nextTerminal - 1][1] == 1) isContinue = true;
                } else if (i == 1) {
                    if (pipe[nextTerminal - 1][0] == 1) isContinue = true;
                } else if (i == 2) {
                    if (pipe[nextTerminal - 1][3] == 1) isContinue = true;
                } else if (i == 3) {
                    if (pipe[nextTerminal - 1][2] == 1) isContinue = true;
                }

                if (isContinue) {
                    visited[nextX][nextY] = true;
                    dfs(nextX, nextY, depth + 1);
                    visited[nextX][nextY] = false;
                }
            }
        }
    }

    public static void bfs(int x, int y, int depth) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, depth});

        while(!queue.isEmpty()) {

            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];
            int curDepth = poll[2];

            mark[curX][curY] = true;

            // 기저 조건 : 시간 달성 시 백
            if (curDepth == standard) {
                continue;
            }

            // 수행
            int curTerminal = map[curX][curY];
            for (int i = 0; i < 4; i++) {

                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 범위 유효성 체크 및 다음 칸에 터널이 존재하는지 확인
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M ||
                        map[nextX][nextY] == 0) continue;

                if (!visited[nextX][nextY]) {

                    // 현재 터널과 다음 터널이 연결되어 있는지 확인
                    int nextTerminal = map[nextX][nextY];
                    if (pipe[curTerminal - 1][i] != 1) {
                        continue;
                    }

                    boolean isContinue = false;
                    if (i == 0) {
                        if (pipe[nextTerminal - 1][1] == 1) isContinue = true;
                    } else if (i == 1) {
                        if (pipe[nextTerminal - 1][0] == 1) isContinue = true;
                    } else if (i == 2) {
                        if (pipe[nextTerminal - 1][3] == 1) isContinue = true;
                    } else if (i == 3) {
                        if (pipe[nextTerminal - 1][2] == 1) isContinue = true;
                    }

                    if (isContinue) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, curDepth + 1});
                    }
                }
            }
        }
    }
}