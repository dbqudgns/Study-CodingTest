package DFS_BFS;

import java.io.*;
import java.util.*;

public class 촌수계산 {

    static int[][] graph;
    static boolean[] visited;
    static int answer = -1;

    public static void dfs(int start, int end, int count) {

       if (start == end) {
           answer = count;
           return;
       }

       visited[start] = true;
       for (int i = 1; i < graph.length; i++) {
           if (!visited[i] && graph[start][i] == 1) {
               dfs(i, end,count+1);
           }
       }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(token.nextToken());
        int end = Integer.parseInt(token.nextToken());

        int size = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < size; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        dfs(start, end, 0);
        System.out.println(answer);
    }
}
