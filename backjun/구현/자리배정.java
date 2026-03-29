package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자리배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(token.nextToken());
        int R = Integer.parseInt(token.nextToken());

        int K = Integer.parseInt(br.readLine());

        if (K > C * R) {
            System.out.print(0);
            return;
        }

        int[][] map = new int[C+1][R+1];

        int[] dx = {0, 1, 0, -1}; // 상우하좌
        int[] dy = {1, 0, -1, 0}; // 상우하좌

        // 초기 방향
        int dirX = 0;
        int dirY = 0;

        // 초기 위치(인덱스)
        int curX = 1;
        int curY = 1;

        for (int i = 1; i <= K; i++) {

            if (map[curX][curY] == 0) {
                map[curX][curY] = i;

                if (i == K) {
                    System.out.print(curX + " " + curY);
                    return;
                }

                // 다음 위치(인덱스)
                int nextX = curX + dx[dirX];
                int nextY = curY + dy[dirY];

                // 다음 위치 인덱스는 1~C, 1~R 여야 한다.
                if ((nextX <= 0 || nextY <= 0 || nextX > C || nextY > R) || map[nextX][nextY] != 0) {

                    // 방향(dx, dy) 인덱스 재설정
                    dirX = (dirX + 1) % 4;
                    dirY = (dirY + 1) % 4;

                    curX += dx[dirX];
                    curY += dy[dirY];
                }
                else {
                    curX = nextX;
                    curY = nextY;
                }
            }
        }
    }
}