package DFS_BFS;

import java.io.*;
import java.util.*;

public class 경비원 {

    static int weight;
    static int height;
    static int[][] map;
    static List<int[]> stores = new ArrayList<>();

    static int targetX, targetY;
    static int[] dx = {0, 0, 1, -1}; // 동서남북
    static int[] dy = {1, -1, 0, 0}; // 동서남북

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        weight = Integer.parseInt(token.nextToken());
        height = Integer.parseInt(token.nextToken());

        int size = Integer.parseInt(br.readLine());

        map = new int[height + 1][weight + 1];

        for (int i = 0; i < size; i++) {
            token = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(token.nextToken());
            int dist = Integer.parseInt(token.nextToken());
            int[] pos = getCoordinate(dir, dist);
            stores.add(pos);
        }

        token = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(token.nextToken());
        int dist = Integer.parseInt(token.nextToken());
        int[] targetPos = getCoordinate(dir, dist);
        targetX = targetPos[0];
        targetY = targetPos[1];


        for (int i = 0; i < size; i++) {
            bfs(stores.get(i)[0], stores.get(i)[1], 0);
        }

        System.out.println(answer);
    }

    public static int[] getCoordinate(int dir, int dist) {

        return switch (dir) {
            case 1 -> new int[]{0, dist};
            case 2 -> new int[]{height, dist};
            case 3 -> new int[]{dist, 0};
            default -> new int[]{dist, weight};
        };
    }

    public static void bfs(int x, int y, int value) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, value});
        boolean[][] visited = new boolean[height + 1][weight + 1];
        visited[x][y] = true;

        while(!queue.isEmpty()) {

            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];

            if (curX == targetX && curY == targetY) {
                answer += poll[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 범위 벗어나는지 확인
                if (nextX < 0 || nextY < 0 || nextX >= height + 1 || nextY >= weight + 1) continue;

                // 내부로 가는지 확인
                if ((nextX > 0 && nextX < height) && (nextY > 0 && nextY < weight)) continue;

                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, poll[2] + 1});
                }

            }
        }
    }
}
