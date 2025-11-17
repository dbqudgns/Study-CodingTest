package DFS_BFS;

import java.util.*;
import java.io.*;

public class 스타트링크 {

    static boolean[] visited;
    static int[] value;
    static int[] upDown;

    public static void bfs(int F, int S, int G) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = true;
        value[S] = 0;

        while(!queue.isEmpty()) {

            int poll = queue.poll();

            if (poll == G) {
                System.out.print(value[poll]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = poll + upDown[i];

                if (next > 0 && next <= F && !visited[next]) {
                    visited[next] = true;
                    value[next] = value[poll] + 1;
                    queue.add(next);
                }
            }
        }
        System.out.print("use the stairs");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(token.nextToken());
        int S = Integer.parseInt(token.nextToken());
        int G = Integer.parseInt(token.nextToken());
        int U = Integer.parseInt(token.nextToken());
        int D = Integer.parseInt(token.nextToken());

        visited = new boolean[F+1]; // 총 1층부터 F층까지
        value = new int[F+1];
        upDown = new int[]{U, -D};

        bfs(F, S, G);
    }
}
