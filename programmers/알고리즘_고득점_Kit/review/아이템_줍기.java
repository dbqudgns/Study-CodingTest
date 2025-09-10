package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 아이템_줍기 {

    // 캐릭터 위치와 이동 횟수를 나타내는 클래스 정의
    static class player {
        int x;
        int y;
        int move;

        public player(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    // 2배 좌표 크기 기준으로 맵 선언
    static int[][] map = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static Queue<player> queue;

    // 방향 벡터 (상하좌우)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    // 최단 거리 결과 저장
    static int answer = Integer.MAX_VALUE;

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        queue = new ArrayDeque<>();

        // 캐릭터 시작 위치를 2배 확장에서 큐에 넣는다.
        queue.add(new player(2 * characterX, 2 * characterY, 0));

        // 주어진 모든 직사각형을 맵에 표시
        for (int i = 0; i < rectangle.length; i++) {
            // 각 직사각형의 좌표를 2배로 확장
            int lx = rectangle[i][0] * 2;
            int ly = rectangle[i][1] * 2;
            int rx = rectangle[i][2] * 2;
            int ry = rectangle[i][3] * 2;

            // 직사각형 전체 영역을 순회
            for (int j = rx; j >= lx; j--) {
                for (int k = ry; k >= ly; k--) {
                    if (map[j][k] == 2) continue;

                    map[j][k] = 2; // 일단 내부로 설정

                    // 만약 경계선이라면 다시 1로 덮어씌운다.
                    if (j == lx || j == rx || k == ly || k == ry) map[j][k] = 1;
                }
            }
        }

        // bfs 시작
        bfs(itemX * 2, itemY * 2);

        return answer/2;
    }

    // BFS
    public static void bfs(int ix, int iy) {
        while(!queue.isEmpty()) {
            player p = queue.poll(); // 현재 위치

            // 목표 지점 도달 시 최소값 갱신 후 종료
            if (p.x == ix && p.y == iy) {
                answer = Math.min(answer, p.move);
            }

            // 이미 방문했거나 테투리가 아닌 경우는 패스 !
            if (visited[p.x][p.y] || map[p.x][p.y] != 1) continue;

            visited[p.x][p.y] = true;

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                // 맵 범위를 벗어나는 경우 제외
                if (nextX < 0 || nextY < 0 || nextX > 100 || nextY > 100) continue;

                // 큐에 다음 위치 추가
                queue.add(new player(nextX, nextY, p.move+1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] rectangle = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                rectangle[i][j] = sc.nextInt();
            }
        }

        int characterX = sc.nextInt();
        int characterY = sc.nextInt();
        int itemX = sc.nextInt();
        int itemY = sc.nextInt();

        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
    }

}
