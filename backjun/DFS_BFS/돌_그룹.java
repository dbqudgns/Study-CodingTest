package DFS_BFS;

import java.util.*;
import java.io.*;

public class 돌_그룹 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());

        System.out.println(bfs(A, B, C) ? 1 : 0);

    }

    public static boolean bfs(int A, int B, int C) {

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[1501][1501];

        queue.add(new int[]{A, B, C});

        while(!queue.isEmpty()) {

            int[] poll = queue.poll();
            int curA = poll[0];
            int curB = poll[1];
            int curC = poll[2];

            if (curA == curB && curB == curC) return true;

            if (curA != curB) {
                int nextA = curA > curB ? curA - curB : curA + curA;
                int nextB = curA < curB ? curB - curA : curB + curB;

                if (nextA <= 1500 & nextB <= 1500 && !visited[nextA][nextB]) {
                    visited[nextA][nextB] = true;
                    queue.add(new int[]{nextA, nextB, curC});
                }
            }

            if (curB != curC) {
                int nextB = curB > curC ? curB - curC : curB + curB;
                int nextC = curB < curC ? curC - curB : curC + curC;

                if (nextB <= 1500 & nextC <= 1500 && !visited[nextB][nextC]) {
                    visited[nextB][nextC] = true;
                    queue.add(new int[]{curA, nextB, nextC});
                }
            }

            if (curA != curC) {
                int nextA = curA > curC ? curA - curC : curA + curA;
                int nextC = curA < curC ? curC - curA : curC + curC;

                if (nextA <= 1500 & nextC <= 1500 && !visited[nextA][nextC]) {
                    visited[nextA][nextC] = true;
                    queue.add(new int[]{nextA, curB, nextC});
                }
            }

        }

        return false;
    }
}
