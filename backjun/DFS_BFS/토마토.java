package DFS_BFS;

import java.util.*;
import java.io.*;

public class 토마토 {

    static int answer = 0;
    static int[][][] graph;
    static int[][] direction = new int[][]{
            {0, 1, 0}, {0, -1, 0},
            {0, 0, -1}, {0, 0, 1},
            {1, 0, 0}, {-1, 0, 0}}; // 상,하,좌,우,위,아래

    public static void bfs() {

        Queue<int[]> queue = new LinkedList<>();

        // 익은 토마토들을 먼저 큐에 넣는다
        for (int h = 0; h < graph.length; h++) {
            for (int n = 0; n < graph[h].length; n++) {
                for (int m = 0; m < graph[h][n].length; m++) {
                    if (graph[h][n][m] == 1) {
                        queue.add(new int[]{h, n, m});
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int h = poll[0];
            int n = poll[1];
            int m = poll[2];

            for (int i = 0; i < 6; i++) {
                int nh = h + direction[i][0];
                int nn = n + direction[i][1];
                int nm = m + direction[i][2];

                if (nh < graph.length && nh >= 0 && nn < graph[0].length && nn >= 0 && nm < graph[0][0].length && nm >= 0) {
                    if (graph[nh][nn][nm] == 0) {
                        graph[nh][nn][nm] = graph[h][n][m] + 1;
                        queue.add(new int[]{nh, nn, nm});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());
        int H = Integer.parseInt(token.nextToken());
        graph = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                token = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    graph[i][j][k] = Integer.parseInt(token.nextToken());
                }
            }
        }

        bfs();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, graph[i][j][k]);
                }
            }
        }

        System.out.println(answer - 1); // 시작값이 1이므로 -1

    }

}
