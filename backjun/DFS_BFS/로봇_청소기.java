package DFS_BFS;

import java.util.*;
import java.io.*;

public class 로봇_청소기 {

    static int N, M;
    static int[][] map;
    static int answer = 1;
    static int[] mx = {-1, 0, 1, 0}; // 북동남서
    static int[] my = {0, 1, 0, -1}; // 북동남서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];

        token = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        int d = Integer.parseInt(token.nextToken());

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int direction) {
        // -1 : 청소를 함, 0 : 청소를 안함, 1 : 벽
        map[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4;
            int nextX = x + mx[direction];
            int nextY = y + my[direction];

            // 90도 회전 시, 빈칸이 있을 경우
            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && map[nextX][nextY] == 0) {
                answer += 1;
                dfs(nextX, nextY, direction);
                return; // 90도 회전할 때 청소하지 않은 곳이 있다면 그곳으로 이동했으니 return;
            }
        }

        // 청소하지 않은 곳이 없다면
        int back = (direction + 2) % 4; // 후진 좌표 이동
        int backX = x + mx[back];
        int backY = y + my[back];

        // 후진할 좌표가 벽이 아니라면?
        if (backX >= 0 && backY >= 0 && backX < N && backY < M && map[backX][backY] != 1) {
            dfs(backX, backY, direction);
        }
    }

}
