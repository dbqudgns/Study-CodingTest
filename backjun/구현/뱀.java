package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀 {

    static int[][] map;
    static int N;
    static Map<Integer, String> moves = new HashMap<>();

    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};
    static int direction = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        int size = Integer.parseInt(br.readLine());
        StringTokenizer token;
        for (int i = 0; i < size; i++) {
            token = new StringTokenizer(br.readLine());
            int appleX = Integer.parseInt(token.nextToken());
            int appleY = Integer.parseInt(token.nextToken());

            map[appleX][appleY] = 2;
        }

        size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            token = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(token.nextToken());
            String dir = token.nextToken();

            moves.put(time, dir);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{1, 1});

        int time = 0;
        while(true) {
            time++; // 1초 흐름

            // 1. 머리를 다음 칸으로 이동 시도
            int[] current = deque.peekFirst();
            int nextX = current[0] + dx[direction];
            int nextY = current[1] + dy[direction];

            // 2. 벽 충돌 or 자기 몸 충돌 체크
            if (nextX <= 0 || nextY <= 0 || nextX >= N+1 || nextY >= N+1 || map[nextX][nextY] == 1) {
                break;
            }

            // 3. 사과 여부에 따른 꼬리 처리
            if (map[nextX][nextY] != 2) {
                int[] tail = deque.pollLast();
                map[tail[0]][tail[1]] = 0;
            }

            // 4. 맴 업데이트
            map[nextX][nextY] = 1;
            deque.addFirst(new int[]{nextX, nextY});


            // 5. 방향 전환 타이밍인지 확인
            if (moves.containsKey(time)) {

                String dir = moves.get(time);

                if (dir.equals("D")) {
                    direction = (direction + 1) % 4;
                }
                else if (dir.equals("L")) {
                    direction = (direction + 3) % 4;
                }
            }
        }

        System.out.println(time);
    }
}