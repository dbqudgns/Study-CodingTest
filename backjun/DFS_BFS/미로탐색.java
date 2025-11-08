package DFS_BFS;

import java.util.*;
import java.io.*;

public class 미로탐색 {

    static int[] dx = {0, 0, -1, 1}; // 좌우상하
    static int[] dy = {1, -1, 0, 0}; // 좌우상하

    public static int bfs(int N, int M, int[][] graph) {
        int[][] visited = new int[N+1][M+1];
        visited[1][1] = 1; //시작점

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cX = current[0];
            int cY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = cX + dx[i];
                int nextY = cY + dy[i];

                if (nextX < 1 || nextX > N || nextY < 1 || nextY > M) continue;

                if (visited[nextX][nextY] == 0 && graph[nextX][nextY] == 1) {
                    visited[nextX][nextY] = visited[cX][cY] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        int answer = visited[N][M];

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[][] graph = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                graph[i][j] = line.charAt(j-1) - '0'; // 문자 -> 숫자 변환
            }
        }

        System.out.println(bfs(N, M, graph));
    }

}
