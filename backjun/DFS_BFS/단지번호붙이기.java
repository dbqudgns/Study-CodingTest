package DFS_BFS;

import java.util.*;
import java.io.*;

public class 단지번호붙이기 {

    static int N, count;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        graph[x][y] = 0;

        while(!queue.isEmpty()) {
            count += 1;
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && graph[nx][ny] == 1) {
                    graph[nx][ny] = 0;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> arr = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count = 0;
                if (graph[i][j] == 1) {
                    bfs(i, j);
                    arr.add(count);
                    result++;
                }
            }
        }

        Collections.sort(arr);
        System.out.println(result);
        for (int i : arr) {
            System.out.println(i);
        }

    }

}
