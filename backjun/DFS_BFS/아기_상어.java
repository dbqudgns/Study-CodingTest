package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 아기_상어 {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int[] cur = null;
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                if (map[i][j] == 9) {
                    cur = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }
        visited = new boolean[N][N];
        bfs(cur);
    }

    public static void bfs(int[] cur) {
        // 먹을 수 있는 물고기가 많다면 거리가 가깝고(o1[2]), 가장 위에 있거나(o1[0]), 가장 왼쪽에 있는 물고기(o1[1]) 순으로 먹는다.
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->
                o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) :
                        Integer.compare(o1[1], o2[1]))
        );

        queue.add(new int[]{cur[0], cur[1], 0}); // 0 : 이동한 거리
        visited[cur[0]][cur[1]] = true; // 시작 위치 방문 처리

        int sharkSize = 2;
        int sharkMove = 0; // 움직인 총 거리(정답)
        int eatFish = 0; // 먹은 물고기 수

        while(true) {

            if (queue.isEmpty()) {
                System.out.println(sharkMove);
                return;
            }

            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];
            int move = poll[2];

            // 1. 먹을 수 있는 물고기인지 확인
            if (map[curX][curY] != 0 && map[curX][curY] < sharkSize) {
                // 물고기를 먹음
                map[curX][curY] = 0;
                eatFish++;
                sharkMove += move;

                // 사이즈 업 체크
                if (eatFish == sharkSize) {
                    sharkSize++;
                    eatFish = 0;
                }

                // 물고기를 먹었으면, 현재 위치를 기준으로 다시 탐색해야 한다.
                // 큐와 방문 배열을 초기화하고 현재 위치부터 거리 0으로 다시 시작
                queue.clear();
                visited = new boolean[N][N];

                queue.add(new int[]{curX, curY, 0}); // 거리는 다시 0부터
                visited[curX][curY] = true;
                continue; // 아래 이동 로직 수행하지 않고 큐의 처음(현재 위치)부터 다시 시작
            }

            // 2. 상하좌우 이동 로직
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 방문하지 않았고 지나갈 수 있는 경우 (물고기 크기 <= 상어 크기)
                if (!visited[nx][ny] && map[nx][ny] <= sharkSize) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, move + 1});
                }
            }
        }
    }
}
