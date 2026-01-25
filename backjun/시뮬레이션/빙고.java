package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 빙고 {

    static int[][] map;
    static boolean[][] visited;
    static boolean[] line;
    static int answer = 0;
    static int count = 0;
    static int finalAnswer = 0;

    public static void main(String[] args) throws IOException {

        map = new int[5][5];
        visited = new boolean[5][5];
        line = new boolean[12];

        Map<Integer, int[]> data = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        for (int i = 0; i < 5; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(token.nextToken());
                map[i][j] = num;
                data.put(num, new int[]{i, j});
            }
        }

        boolean cnu = false;
        for (int i = 0; i < 5; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(token.nextToken());
                int[] ints = data.get(num);
                visited[ints[0]][ints[1]] = true;
                count++;

                exam(ints[0], ints[1]);
                if (answer >= 3 && !cnu) {
                    finalAnswer = count;
                    cnu = true;
                }
            }
        }

        System.out.println(finalAnswer);
    }

    public static void exam(int x, int y) {

        // 가로 검증
        if (!line[x]) {
            int num = 0;
            for (int j = 0; j < 5; j++) {
                if (visited[x][j]) num++;
            }

            if (num == 5) {
                line[x] = true;
                answer++;
            }
        }

        // 세로 검증
        if (!line[y + 5]) {
            int num = 0;
            for (int i = 0; i < 5; i++) {
                if (visited[i][y]) num++;
            }

            if (num == 5) {
                line[y + 5] = true;
                answer++;
            }
        }

        // 오른쪽 대각선 검증
        if (!line[10] && ((x == 0 && y == 4) || (x == 1 && y == 3) || (x == 2 && y == 2) || (x == 3 && y == 1) || (x == 4 && y == 0))) {
            int num = 0;
            if (visited[0][4]) num++;
            if (visited[1][3]) num++;
            if (visited[2][2]) num++;
            if (visited[3][1]) num++;
            if (visited[4][0]) num++;

            if (num == 5) {
                line[10] = true;
                answer++;
            }
        }

        // 왼쪽 대각선 검증
        if (!line[11] && ((x == 0 && y == 0) || (x == 1 && y == 1) || (x == 2 && y == 2) || (x == 3 && y == 3) || (x == 4 && y == 4))) {
            int num = 0;
            if (visited[0][0]) num++;
            if (visited[1][1]) num++;
            if (visited[2][2]) num++;
            if (visited[3][3]) num++;
            if (visited[4][4]) num++;

            if (num == 5) {
                line[11] = true;
                answer++;
            }
        }
    }
}