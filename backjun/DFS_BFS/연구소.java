package DFS_BFS;

import java.util.*;
import java.io.*;

public class 연구소 {

    static int N, M;
    static int[][] map;
    static int answer = 0;

    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};

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

        dfs(0);

        System.out.println(answer);
    }

    // 임의의 3개의 벽 세우기
    public static void dfs(int count) {

        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1);
                    map[i][j] = 0; // 백트래킹
                }
            }
        }

    }

    // 3개의 벽을 세운 map에 바이러스 퍼트리기
    public static void bfs() {

        Queue<int[]> queue = new ArrayDeque<>();

        // 일단 큐에 부모 바이러스들의 좌표를 넣자
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] virusMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            virusMap[i] = map[i].clone();
        }

        // 바이러스 퍼트리기
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int virusX = poll[0];
            int virusY = poll[1];

            for (int i = 0; i < 4; i++) {

                int dx = virusX + mx[i];
                int dy = virusY + my[i];

                if (dx < 0 || dy < 0 || dx >= N || dy >= M) continue;

                if (virusMap[dx][dy] == 0) {
                    virusMap[dx][dy] = 2;
                    queue.add(new int[]{dx, dy});
                }
            }
        }

        // 안전 영역 개수 세기
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 0) {
                    count++;
                }
            }
        }

        answer = Math.max(answer, count);

    }

}
