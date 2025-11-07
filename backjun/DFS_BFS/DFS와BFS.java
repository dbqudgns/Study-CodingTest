package DFS_BFS;

import java.util.*;
import java.io.*;

public class DFS와BFS {

    static int N,M,V;
    static int[][] graph;
    static boolean[] visited;

    public static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next = 1; next <= N; next++) {
            if (graph[node][next] == 1 && !visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        System.out.print(node + " ");

        while(!queue.isEmpty()) {
            int poll = queue.poll();

            // 전체 정점 순회
            for (int next = 1; next <= N; next++) {
                if (graph[poll][next] == 1 && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    System.out.print(next + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // InputStreamReader : 바이트 스트림인 System.in을 문자 스트림으로 변경시키는 작업 수행
        // BufferedReader : InputStreamReader 클래스를 이용해 변환된 문자 스트림을 버퍼 스트림에 저장 수행
        // 쉽게 말해, 데이터를 상자에 가공하여 적재시키는 단계
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer : 버퍼를 활용하여 readLine()으로 줄 단위로 입력을 받은 후, 공백으로 데이터를 구분한다.
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken()); // 정점의 개수
        M = Integer.parseInt(token.nextToken()); // 간선의 개수
        V = Integer.parseInt(token.nextToken()); // 시작 정점

        // 정점 초기화 (정점은 1부터 시작)
        graph = new int[N+1][N+1];

        for (int v = 0; v < M; v++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            graph[a][b] = graph[b][a] = 1; // 양방향 정점 연결
        }

        visited = new boolean[N+1];
        dfs(V);

        System.out.println();

        visited = new boolean[N+1];
        bfs(V);

    }
}
