package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 토마토_7576 {

    static int N, M;
    static int[][] map;
    static List<int[]> lists;

    static int answer = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[M][N];
        lists = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                if (map[i][j] == 1) {
                    lists.add(new int[]{i, j});
                }
            }
        }

        bfs();
        System.out.print(answer);
    }

    public static void bfs() {

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < lists.size(); i++) {
            int[] get = lists.get(i);
            queue.add(new int[]{get[0], get[1], 0});
        }

        while(!queue.isEmpty()) {

            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;

                if (map[nextX][nextY] == 0) {
                    answer = poll[2] + 1;
                    queue.add(new int[] {nextX, nextY, poll[2] + 1});
                    map[nextX][nextY] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    answer = -1;
                    return;
                }
            }
        }
    }

}
