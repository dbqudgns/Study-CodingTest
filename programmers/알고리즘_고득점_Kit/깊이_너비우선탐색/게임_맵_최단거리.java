package 알고리즘_고득점_Kit.깊이_너비우선탐색;

import java.util.*;

public class 게임_맵_최단거리 {

    static int[] dX = {0, 0, 1, -1}; // 동, 서, 남, 북
    static int[] dY = {1, -1, 0, 0}; // 동, 서, 남, 북

    public static int solution(int[][] maps) {
        int answer = 0;

        // 방문한 위치에 이동 횟수를 저장할 배열
        int[][] visited = new int[maps.length][maps[0].length];

        // BFS 탐색 수행
        bfs(maps, visited);

        // 상대 진영 위치의 값이 0이면 도달하지 못한 것이므로 -1 반환
        answer = visited[maps.length - 1][maps[0].length - 1];
        if (answer == 0) {
            answer = -1;
        }

        return answer;

    }

    public static void bfs(int[][] maps, int[][] visited) {
        int x = 0; // 시작 지점 x좌표 (0,0)
        int y = 0; // 시작 지점 y좌표 (0,0)
        visited[x][y] = 1; // 시작 위치는 1로 초기화 (이동 횟수)

        // BFS 탐색을 위한 큐 생성
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y}); // 시작 위치를 큐에 추가

        while(!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 위치를 꺼낸다.
            int cX = current[0]; // 현재 x 좌표
            int cY = current[1]; // 현재 y 좌표

            // 4뱡향으로 이동 시도
            for (int i = 0; i < 4; i++) {
                int nX = cX + dX[i]; // 다음 x좌표
                int nY = cY + dY[i]; // 다음 y좌표

                // 맵을 벗어나면 무시
                if (nX < 0 || nX >= maps.length || nY < 0 || nY >= maps[0].length) continue;

                // 아직 방문하지 않았고 벽이 아닌 곳일 경우
                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    // 경로가 가장 빠른 곳이 먼저 visited 하기 때문에 다른 곳에서온 경로도 visited = true로 인해 끊기게 된다.
                    visited[nX][nY] = visited[cX][cY] + 1; // 이전위치 + 1
                    queue.add(new int[]{nX, nY}); // 큐에 다음 위치 추가
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] maps = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(maps));
    }
}
