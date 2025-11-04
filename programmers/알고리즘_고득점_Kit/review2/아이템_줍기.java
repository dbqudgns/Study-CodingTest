package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 아이템_줍기 {

    static class player {
        int x;
        int y;
        int move; // 이동 횟수

        public player(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    // 2배 좌표 크기 기준으로 맵 선언 : 1,1부터 100,100 확보를 위해 101로 설정
    static int[][] map = new int[101][101];
    static boolean[][] visited = new boolean[101][101]; // 방문 여부
    static Queue<player> queue; // bfs를 위한 큐

    // 방향 벡터 : 좌우상하
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    // 최단 거리 결과 저장
    static int answer = Integer.MAX_VALUE;

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        queue = new LinkedList<>();

        // 캐릭터 시작 위치를 큐에 넣는다. => 좌표를 2배로 확장해서 넣기
        queue.add(new player(2 * characterX, 2 * characterY, 0));

        // 주어진 모든 직사각형을 맵에 표시
        for (int i = 0; i < rectangle.length; i++) {
            // 각 직사각형의 좌하단, 우상단 좌표를 2배로 확장
            int lx = rectangle[i][0] * 2;
            int ly = rectangle[i][1] * 2;
            int rx = rectangle[i][2] * 2;
            int ry = rectangle[i][3] * 2;

            // 직사각형 전체 영역을 순회
            for (int j = rx; j >= lx; j--) {
                for (int k = ry; k >= ly; k--) {
                    if (map[j][k] == 2) continue; // 이미 내부로 표시된 곳은 건너뛴다.

                    map[j][k] = 2; // 일단 내부로 설정

                    // 만약 경계선이라면 다시 1로 덮어씌운다.
                    if (j == lx || j == rx || k == ly || k == ry) map[j][k] = 1;
                }
            }
        }

        // bfs 시작 (아이템 위치도 2배 확장)
        bfs(2 * itemX, 2 * itemY);

        // 좌표를 2배 확장했으므로, 이동 거리도 2로 나눠준다.
        return answer / 2;

    }

    public static void bfs(int ix, int iy) {
        while(!queue.isEmpty()) {
            player p = queue.poll(); // 현재 위치 반환

            // 목표 지점 도달 시 최소값 갱신 후 종료
            if (p.x == ix && p.y == iy) {
                answer = Math.min(answer, p.move);
                return;
            }

            // 이미 방문했거나, 테두리가 아닌 경우는 패스!!
            if (visited[p.x][p.y] || map[p.x][p.y] != 1) continue;
            visited[p.x][p.y] = true;

            // 좌우상하 이동
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                // 맵 범위를 벗어나는 경우 제외
                if (nextX < 0 || nextY < 0 || nextX > 100 || nextY > 100) continue;

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
