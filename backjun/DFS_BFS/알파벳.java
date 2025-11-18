package DFS_BFS;

import java.util.*;
import java.io.*;

public class 알파벳 {

    static String[][] map;
    static boolean[] alphaUsed = new boolean[26];
    static int answer = 0;
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};

    public static void dfs(int x, int y, int count) {

        answer = Math.max(answer, count);

        for (int i = 0; i < 4; i++) {

            int dx = x + mx[i];
            int dy = y + my[i];

            if ((0 <= dx && dx < map.length) && (0 <= dy && dy < map[0].length)) {

                int idx = map[dx][dy].charAt(0) - 'A';

                if (!alphaUsed[idx]) {
                    alphaUsed[idx] = true;
                    dfs(dx, dy, count + 1);
                    alphaUsed[idx] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());

        map = new String[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            String[] split = str.split("");

            for (int j = 0; j < C; j++) {
                map[i][j] = split[j];
            }
        }

        int first = map[0][0].charAt(0) - 'A';
        alphaUsed[first] = true;

        dfs(0, 0, 1);

        System.out.println(answer);
    }
}
