package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 파이프_옮기기1 {

    static int N;
    static int[][] map;

    static int[] widthX = {0, 1};
    static int[] widthY = {1, 1};
    static int[] verticalX = {1, 1};
    static int[] verticalY = {0, 1};
    static int[] diagonalX = {0, 1, 1};
    static int[] diagonalY = {1, 0, 1};

    static int[] wallX = {-1, 0};
    static int[] wallY = {0, -1};

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        StringTokenizer token;
        for (int i = 1; i < N+1; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        dfs(1, 2, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.println(sb);
    }

    /**
     * bfs() 문제 : 파이프의 현재 상태를 고려하지 않고
     * 가로, 세로, 대각선 전체를 수행함
     */
    public static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 2});

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];

            if (curX == N && curY == N) {
                answer++;
                continue;
            }

            // 가로
            for (int i = 0; i < 2; i++) {
                int nextX = curX + widthX[i];
                int nextY = curY + widthY[i];

                if (nextX <= 0 || nextY <= 0 || nextX > N || nextY > N || map[nextX][nextY] == 1) {
                    continue;
                }

                boolean con = true;
                if (i == 1) {

                    for (int j = 0; j < 2; j++) {
                        int curWallX = nextX + wallX[j];
                        int curWallY = nextY + wallY[j];

                        if (map[curWallX][curWallY] == 1) {
                            con = false;
                            break;
                        }
                    }
                }

                if (con) {
                    System.out.println(nextX + " " + nextY);
                    queue.add(new int[]{nextX, nextY});
                }
            }

            // 세로
            for (int i = 0; i < 2; i++) {
                int nextX = curX + verticalX[i];
                int nextY = curY + verticalY[i];

                if (nextX <= 0 || nextY <= 0 || nextX > N || nextY > N || map[nextX][nextY] == 1) {
                    continue;
                }

                boolean con = true;
                if (i == 1) {

                    for (int j = 0; j < 2; j++) {
                        int curWallX = nextX + wallX[j];
                        int curWallY = nextY + wallY[j];

                        if (map[curWallX][curWallY] == 1) {
                            con = false;
                            break;
                        }
                    }
                }

                if (con) {
                    queue.add(new int[]{nextX, nextY});
                }
            }

            // 대각선
            for (int i = 0; i < 3; i++) {
                int nextX = curX + diagonalX[i];
                int nextY = curY + diagonalY[i];

                if (nextX <= 0 || nextY <= 0 || nextX > N || nextY > N || map[nextX][nextY] == 1) {
                    continue;
                }

                boolean con = true;
                if (i == 2) {

                    for (int j = 0; j < 2; j++) {
                        int curWallX = nextX + wallX[j];
                        int curWallY = nextY + wallY[j];

                        if (map[curWallX][curWallY] == 1) {
                            con = false;
                            break;
                        }
                    }
                }

                if (con) {
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    /**
     * bfs2() 문제 : queue.add(~) 부분에서 반복문이 돌 때마다
     * 새로운 2차 배열 객체를 힙 메모리에 계속 생성한다.
     * 자바에서 이는 상당한 오버헤드를 발생시켜 시간 초과가 발생한다.
     */
    public static void bfs2() {
        Queue<int[][]> queue = new ArrayDeque<>();
        queue.add(new int[][]{{1,1}, {1, 2}});

        while(!queue.isEmpty()) {

            int[][] poll = queue.poll();
            int[] first = poll[0];
            int[] second = poll[1];

            if (second[0] == N && second[1] == N) {
                answer++;
                continue;
            }

            // 파이프가 가로일 때
            if (second[0] - first[0] == 0 && second[1] - first[1] == 1) {
                // 가로
                for (int i = 0; i < 2; i++) {
                    int nextX = second[0] + widthX[i];
                    int nextY = second[1] + widthY[i];

                    if (nextX <= 0 || nextY <= 0 || nextX > N || nextY > N || map[nextX][nextY] == 1) {
                        continue;
                    }

                    boolean con = true;
                    if (i == 1) {

                        for (int j = 0; j < 2; j++) {
                            int curWallX = nextX + wallX[j];
                            int curWallY = nextY + wallY[j];

                            if (map[curWallX][curWallY] == 1) {
                                con = false;
                                break;
                            }
                        }
                    }

                    if (con) {
                        queue.add(new int[][]{{second[0], second[1]}, {nextX, nextY}});
                    }
                }
            }
            // 파이프가 세로일 때
            else if (second[0] - first[0] == 1 && second[1] - first[1] == 0) {
                for (int i = 0; i < 2; i++) {
                    int nextX = second[0] + verticalX[i];
                    int nextY = second[1] + verticalY[i];

                    if (nextX <= 0 || nextY <= 0 || nextX > N || nextY > N || map[nextX][nextY] == 1) {
                        continue;
                    }

                    boolean con = true;
                    if (i == 1) {

                        for (int j = 0; j < 2; j++) {
                            int curWallX = nextX + wallX[j];
                            int curWallY = nextY + wallY[j];

                            if (map[curWallX][curWallY] == 1) {
                                con = false;
                                break;
                            }
                        }
                    }

                    if (con) {
                        queue.add(new int[][]{{second[0], second[1]}, {nextX, nextY}});
                    }
                }
            }
            // 파이프가 대각선일 때
            else {
                for (int i = 0; i < 3; i++) {
                    int nextX = second[0] + diagonalX[i];
                    int nextY = second[1] + diagonalY[i];

                    if (nextX <= 0 || nextY <= 0 || nextX > N || nextY > N || map[nextX][nextY] == 1) {
                        continue;
                    }

                    boolean con = true;
                    if (i == 2) {

                        for (int j = 0; j < 2; j++) {
                            int curWallX = nextX + wallX[j];
                            int curWallY = nextY + wallY[j];

                            if (map[curWallX][curWallY] == 1) {
                                con = false;
                                break;
                            }
                        }
                    }

                    if (con) {
                        queue.add(new int[][]{{second[0], second[1]}, {nextX, nextY}});
                    }
                }
            }
        }
    }

    /**
     * DFS() : DFS를 적용하여 재귀 호출로 메모리 절약
     */
    public static void dfs(int curX, int curY, int type) {

        if (curX == N && curY == N) {
            answer++;
            return;
        }

        int[] calX;
        int[] calY;
        int forLoop = 0;
        int wallIndex = 0;

        // 가로일 경우
        if (type == 0) {
            calX = widthX;
            calY = widthY;
            wallIndex = 1;
            forLoop = 2;
        }
        else if(type == 1) { // 세로일 경우
            calX = verticalX;
            calY = verticalY;
            wallIndex = 1;
            forLoop = 2;
        }
        else { // 대각선일 경우
          calX = diagonalX;
          calY = diagonalY;
          wallIndex = 2;
          forLoop = 3;
        }

        for (int i = 0; i < forLoop; i++) {
            int nextX = curX + calX[i];
            int nextY = curY + calY[i];

            if (nextX <= 0 || nextY <= 0 || nextX > N || nextY > N || map[nextX][nextY] == 1) {
                continue;
            }

            int nextType = -1;
            if (type == 0) {
                if (i == 0) nextType = 0;
                else nextType = 2;
            }
            else if (type == 1) {
                if (i == 0) nextType = 1;
                else nextType = 2;
            }
            else {
                if (i == 0) nextType = 0;
                else if (i == 1) nextType = 1;
                else nextType = 2;
            }

            boolean con = true;
            if (i == wallIndex) {
                for (int j = 0; j < 2; j++) {
                    int checkWallX = nextX + wallX[j];
                    int checkWallY = nextY + wallY[j];

                    if (map[checkWallX][checkWallY] == 1) {
                        con = false;
                        break;
                    }
                }
            }

            if (con) {
                dfs(nextX, nextY, nextType);
            }
        }
    }
}

