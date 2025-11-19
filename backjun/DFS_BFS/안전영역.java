package DFS_BFS;

import java.util.*;
import java.io.*;

public class 안전영역 {

    static int N;
    static int maxNum; // 영역 내 최대 원소
    static int[][] area;
    static boolean[][] visited;
    static int[] mx = {-1, 1, 0, 0}; // 상하좌우
    static int[] my = {0, 0, -1, 1}; // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        area = new int[N][N];

        maxNum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(token.nextToken());
                maxNum = Math.max(maxNum, area[i][j]);
            }
        }

        int maxHeight = 0;
        for (int i = 0; i <= maxNum; i++) {
            int height = i; // 높이
            visited = new boolean[N][N];
            int count = 0; // 안전 영역 총 개수

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (area[j][k] > height && !visited[j][k]) {
                        count += dfs(j, k, height);
                    }
                }
            }
            maxHeight = Math.max(maxHeight, count);
        }

        System.out.println(maxHeight);
    }

    public static int dfs(int x, int y, int height) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + mx[i];
            int nextY = y + my[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;

            if (!visited[nextX][nextY] && height < area[nextX][nextY]) {
                dfs(nextX, nextY, height);
            }
        }

        return 1;
    }

}
