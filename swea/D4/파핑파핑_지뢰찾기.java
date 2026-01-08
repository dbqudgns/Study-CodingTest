package D4;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class 파핑파핑_지뢰찾기 {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        char map[][];
        boolean visited[][];
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            map = new char[N][N];
            visited = new boolean[N][N];

            sc.nextLine();
            for (int i = 0; i < N; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            // 주변 8개의 구역에 지뢰의 개수를 얻어 각 칸에 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != '*') {
                        countBombAndInsertBomb(map, N, i, j);
                    }
                }
            }

            int answer = 0;

            // 0인 칸(주변에 지뢰가 없는 칸) 우선 클릭
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '0' && !visited[i][j]) {
                        bfs(map, visited, i, j);
                        answer++;
                    }
                }
            }

            // 나머지 안전한 칸들 처리
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != '*' && !visited[i][j]) {
                        answer++;
                    }
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }


    public static void countBombAndInsertBomb(char[][] map, int N, int x, int y) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;

            if (map[nextX][nextY] == '*') sum++;
        }

        map[x][y] = (char)('0' + sum);
    }

    public static void bfs(char[][] map, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i = 0; i < 8; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length || visited[nextX][nextY]) continue;
                visited[nextX][nextY] = true;

                if (map[nextX][nextY] == '0') {
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }
    }
}
