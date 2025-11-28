package DFS_BFS;

import java.util.*;
import java.io.*;

public class 데스_나이트 {

    static int N;
    static int[] mx = {-2, -2, 0, 0, 2, 2};
    static int[] my = {-1, 1, -2, 2, -1, 1};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(token.nextToken());
        int c1 = Integer.parseInt(token.nextToken());
        int r2 = Integer.parseInt(token.nextToken());
        int c2 = Integer.parseInt(token.nextToken());

        bfs(r1, c1, r2, c2);
    }

    public static void bfs(int r1, int c1, int r2, int c2) {

        visited = new int[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r1, c1});

        while(!queue.isEmpty()) {

            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];

            if (r == r2 && c == c2) {
                System.out.println(visited[r][c]);
                return;
            }

            for (int i = 0; i < 6; i++) {
                int dr = r + mx[i];
                int dc = c + my[i];

                if (dr < 0 || dc < 0 || dr >= N || dc >= N) continue;

                if (visited[dr][dc] == 0) {
                    visited[dr][dc] = visited[r][c] + 1;
                    queue.add(new int[]{dr, dc});
                }

            }

        }

        System.out.println(-1);

    }

}
