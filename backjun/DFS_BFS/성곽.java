package DFS_BFS;

import java.util.*;
import java.io.*;

public class 성곽 {

    // 기준 : 서, 북, 동, 남
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] wall = {1, 2, 4, 8};

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] room; // 현재 방이 몇 번방에 속하는지
    static List<Integer> roomSize = new ArrayList<>(); // 특정 방의 넓이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int roomCount = 0; // 1. 성에 있는 방의 개수
        int maxRoom = 0; // 2. 최대 방 넓이
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    int size = bfs(i, j, roomCount);
                    maxRoom = Math.max(maxRoom, size);
                    roomSize.add(size);
                    roomCount++;
                }
            }
        }

        int maxAfterRemove = maxRoom; // 3. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 2; d <= 3; d++) { // 동, 남만 체크 : 같은 벽을 두 번 보는 것을 방지 (A->B(동), B->A(서))
                    int nextX = i + dx[d];
                    int nextY = j + dy[d];

                    // 지도 밖은 무시
                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

                    int room1 = room[i][j]; // 현재 칸의 방 번호
                    int room2 = room[nextX][nextY]; // 이웃 칸의 방 번호

                    // 현재 두 방의 번호가 다르면?
                    if (room1 != room2) {
                        maxAfterRemove = Math.max(maxAfterRemove, roomSize.get(room1) + roomSize.get(room2));
                    }
                }
            }
        }

        System.out.println(roomCount);
        System.out.println(maxRoom);
        System.out.println(maxAfterRemove);
    }

    public static int bfs(int x, int y, int roomCount) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        room[x][y] = roomCount;

        int roomSize = 1;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];

            for (int i = 0; i < 4; i++) {

                // 비트마스킹 : 현재 방의 특정 위치의 벽(wall[i])이 있으면 안됨
                if((map[curX][curY] & wall[i]) != 0) continue;

                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                room[nextX][nextY] = roomCount;
                queue.add(new int[]{nextX, nextY});
                roomSize++;
            }
        }
        return roomSize;
    }


}
