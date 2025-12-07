package DFS_BFS;

import java.util.*;
import java.io.*;

public class 연구소2 {

    static int N, M;
    static int[][] map;
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        dfs(0, 0, 0);

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);

    }

    // M개의 바이러스 구역 설정(=3)
    // [수정] 시간초과 나서 startX, startY를 추가해서 이중 for문을 유지하되 중복을 제거
    public static void dfs(int startX, int startY, int count) {

        if (count == M) {
            bfs();
            return;
        }

        // 받아온 startX부터 탐색 시작
        for (int i = startX; i < N; i++) {
            // 만약 현재 행(i)이 시작 행(startX)과 같다면, 열(j)은 startY부터 시작
            int k = (i == startX) ? startY : 0;

            for (int j = k; j < N; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 3;
                    // 다음 재귀는 현재 위치 다음 칸(j+1)부터 보라고 넘겨준다.
                    dfs(i, j + 1, count + 1);
                    map[i][j] = 2;
                }
            }
        }

    }

    public static void bfs() {

        int[][] visited = new int[N][N];

        // [수정] 방문 배열을 -1로 초기화 (0초와 방문 안함을 구분하기 위함)
        for (int i = 0; i < N; i++) Arrays.fill(visited[i], -1);

        int[][] virusMap = new int[N][N];

        // 처음 바이러스가 놓을 위치(=3)을 놓는다.
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            virusMap[i] = map[i].clone();
            for (int j = 0; j < N; j++) {
                if (virusMap[i][j] == 3) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = 0; // 시작 시간 0
                }
            }
        }

        int maxTime = 0;
        while(!queue.isEmpty()) {

            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            maxTime = Math.max(visited[currentX][currentY], maxTime);

            for (int i = 0; i < 4; i++) {

                int moveX = currentX + mx[i];
                int moveY = currentY + my[i];

                // 범위를 벗어나거나 벽(1)일 경우 continue;
                if (moveX < 0 || moveY < 0 || moveX >= N || moveY >= N || virusMap[moveX][moveY] == 1)
                    continue;

                // 방문 하지 않았고(1),
                // 벽이 아닌 경우(0 or 2) -> 이거는 생략 가능
                // why 생략 가능? 바이러스가 놓일 것은 visited 0처리 해놧고, 벽(1)일 경우 continue 처리 했으므로 생략 가능
                if (visited[moveX][moveY] == -1) {
                    visited[moveX][moveY] = visited[currentX][currentY] + 1;
                    queue.add(new int[]{moveX, moveY});
                }
            }

        }

        if (proceedAll(virusMap, visited))
            answer = Math.min(maxTime, answer);

    }

    public static boolean proceedAll(int[][] virusMap, int[][] visited) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // [수정] 벽(1)이 아닌데 방문하지 않았다면(-1) 실패
                // 선택되지 않은 바이러스 위치(2)도 빈 칸 취급되어야 함
                if (virusMap[i][j] != 1 && visited[i][j] == -1) {
                    return false;
                }
            }
        }

        // 모두 다 방문하였으면 true 반환
        return true;
    }

}
