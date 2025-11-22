package DFS_BFS;

import java.util.*;
import java.io.*;

public class 빙산 {

    static int N, M;
    static int[][] map;
    static int[] mx = {-1, 1, 0, 0}; // 상하좌우
    static int[] my = {0, 0, -1, 1}; // 상하좌우
    static int year = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        while(true) {

            year++;

            // 1. 1행1열부터 순회하면서 빙산의 높이 새로운 map에 옮기기
            int[][] newMap = new int[N][M];
            for (int i = 1; i < N-1; i++) {
                for (int j = 1; j < M-1; j++) {
                    if (map[i][j] > 0) {
                        int count = 0;
                        for (int k = 0; k < 4; k++) {
                            int nextX = i + mx[k];
                            int nextY = j + my[k];

                            if (map[nextX][nextY] == 0) count++;
                        }
                        newMap[i][j] = Math.max(0, map[i][j] - count);
                    }
                }
            }

            int answer = countCM(newMap);
            if (answer == 0) {
                System.out.println(0);
                return;
            }
            else if (answer >= 2) {
                System.out.println(year);
                return;
            }
            map = newMap;
        }
    }

    static int countCM(int[][] newMap) {

        int answer = 0;
        boolean[][] visited = new boolean[N][M];


        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < M-1; j++) {
                if (newMap[i][j] != 0 && !visited[i][j]) {
                    answer += dfs(i, j, newMap, visited);
                }
            }
        }

        return answer;
    }

    static int dfs(int x, int y, int[][] newMap, boolean[][] visited) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + mx[i];
            int nextY = y + my[i];

            if (newMap[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                dfs(nextX, nextY, newMap, visited);
            }
        }

        return 1;
    }

}
