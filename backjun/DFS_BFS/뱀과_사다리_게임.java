package DFS_BFS;

import java.util.*;
import java.io.*;

public class 뱀과_사다리_게임 {

    static int[] board;
    static boolean[] visited;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        board = new int[101];
        for (int i = 1; i < board.length; i++) {
            board[i] = i;
        }

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            board[x] = y;
        }

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            board[x] = y;
        }

        bfs();
        System.out.println(answer);

    }

    public static void bfs() {
        visited = new boolean[101];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = false;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];
            int count = poll[1];

            if (current == 100) {
                answer = count;
            }

            for (int i = 1; i <= 6; i++) {

                int newCur = current + i;
                if (newCur > 100) continue;

                int move = board[newCur];

                if(move <= 100 && !visited[move]) {
                    visited[move] = true;
                    queue.add(new int[]{move, count+1});
                }
            }
        }
    }

}
