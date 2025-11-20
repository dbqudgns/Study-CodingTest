package DFS_BFS;

import java.util.*;
import java.io.*;

public class 맥주_마시면서_걸어가기 {

    static List<int[]> list;
    static int startX, startY, endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int j = 0; j < t; j++) {
            list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());

                if (i == 0) {
                    startX = Integer.parseInt(token.nextToken());
                    startY = Integer.parseInt(token.nextToken());
                } else if (i == n + 1) {
                    endX = Integer.parseInt(token.nextToken());
                    endY = Integer.parseInt(token.nextToken());
                } else {
                    int x = Integer.parseInt(token.nextToken());
                    int y = Integer.parseInt(token.nextToken());
                    list.add(new int[]{x, y});
                }

            }
            System.out.println(bfs() ? "happy" : "sad");
        }
    }

    public static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});

        boolean[] visited = new boolean[list.size()]; // 편의점 방문 여부

        while(!queue.isEmpty()) {

            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            // 현재 정점과 페스티벌 사이의 거리가 1000m 이하이면 페스티벌까지 걸어갈 수 있다.
            if (Math.abs(currentX - endX) + Math.abs(currentY - endY) <= 1000) {
                return true;
            }

            for (int i = 0; i < list.size(); i++) {
                int px = list.get(i)[0];
                int py = list.get(i)[1];

                // 현재 정점과 편의점 사이의 거리가 1000m 이하이고 해당 편의점을 방문하지 않았다면 큐에 넣는다.
                if (Math.abs(currentX - px) + Math.abs(currentY - py) <= 1000 && !visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{px, py});
                }
            }
        }
        return false;
    }

}
