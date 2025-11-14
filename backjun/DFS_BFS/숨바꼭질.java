package DFS_BFS;

import java.util.*;
import java.io.*;

public class 숨바꼭질 {

    static int N, K;
    static int answer;
    static boolean[] visited = new boolean[100001];

    public static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        visited[N] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];
            int time = poll[1];

            if (current == K) {
                answer = time;
                break;
            }

            int[] next = {current-1, current+1, current*2};
            for (int nx : next) {
                if (nx >= 0 && nx <= 100000 && !visited[nx]) {
                    visited[nx] = true;
                    queue.add(new int[]{nx, time + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        bfs();
        System.out.println(answer);

    }

}
