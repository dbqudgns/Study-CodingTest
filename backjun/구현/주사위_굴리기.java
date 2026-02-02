package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위_굴리기 {

    static int N, M, curX, curY, K; // curX, curY : 현재 위치는 계속 갱신할 예정
    static int[][] map;

    // 차례 : 동쪽(1), 서쪽(2), 북쪽(3), 남쪽(4), 위(5), 아래(6)
    static int[] dice = new int[7]; // 주사위의 현재 상태를 담는 배열

    // 입력 받은 동서남북에 따른 델타 변수
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        curX = Integer.parseInt(token.nextToken());
        curY = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(token.nextToken());

            // 1. dir(방향)에 맞춰 주사위의 다음 좌표로 이동
            int nextX = curX + dx[dir];
            int nextY = curY + dy[dir];

            // 2. 다음 좌표가 범위를 벗어나면 출력도 안함!
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }

            // 3. 현재 좌표 업데이트 하고 방향에 맞춰 현재 주사위의 동서남북, 윗면, 아랫면 상태 업데이트
            curX = nextX;
            curY = nextY;
            solution(dir); // 업데이트


            // 4. 현재 맵과 주사위 밑면 설정
            // 현재 맵이 0이라면, 주사위의 값을 맵에 넣는다.
            if (map[curX][curY] == 0) {
                map[curX][curY] = dice[6];
            }
            // 현재 맵이 0이 아니라면, 칸에 있는 수가 주사위의 밑면에 복사되며 칸은 0으로 변경
            else if (map[curX][curY] != 0) {
                dice[6] = map[curX][curY];
                map[curX][curY] = 0;
            }

            // 5. 현재 주사위의 윗면 추가
            sb.append(dice[5] + "\n");
        }

        System.out.print(sb);
    }


    public static void solution(int dir) {

        int temp = dice[5]; // 윗면 임시 저장

        switch (dir) {
            // 동쪽
            case 1:

                dice[5] = dice[2]; // 서쪽 -> 위쪽
                dice[2] = dice[6]; // 밑변 -> 서쪽
                dice[6] = dice[1]; // 동쪽 -> 밑변
                dice[1] = temp; // 윗면 -> 동쪽
                break;

            // 서쪽
            case 2:

                dice[5] = dice[1]; // 동쪽 -> 위쪽
                dice[1] = dice[6]; // 밑변 -> 동쪽
                dice[6] = dice[2]; // 서쪽 -> 밑변
                dice[2] = temp; // 윗면 -> 서쪽
                break;

            // 북쪽
            case 3:

                dice[5] = dice[4]; // 남쪽 -> 윗변
                dice[4] = dice[6]; // 밑변 -> 남쪽
                dice[6] = dice[3]; // 북쪽 -> 밑변
                dice[3] = temp; // 윗면 -> 동쪽
                break;

            // 남쪽
            case 4:

                dice[5] = dice[3]; // 북쪽 -> 윗변
                dice[3] = dice[6]; // 밑변 -> 북쪽
                dice[6] = dice[4]; // 남쪽 -> 밑변
                dice[4] = temp; // 윗면 -> 남쪽
                break;
        }
    }
}
