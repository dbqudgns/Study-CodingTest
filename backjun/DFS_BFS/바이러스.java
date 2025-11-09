package DFS_BFS;

import java.util.*;
import java.io.*;

public class 바이러스 {

    static int[][] graph;
    static boolean[] visited;

    public static int bfs() {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()) {

            int poll = queue.poll();

            for (int i = 1; i < graph[poll].length; i++) {
                if (graph[poll][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int computerSize = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        int networkSize = Integer.parseInt(token.nextToken());

        graph = new int[computerSize+1][computerSize+1];

        for (int i = 0; i < networkSize; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            graph[a][b] = graph[b][a] = 1; // 양방향 정점 연결
        }

        visited = new boolean[computerSize+1];

        System.out.println(bfs());
    }

}
