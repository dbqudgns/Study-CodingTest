package DFS_BFS;

import java.util.*;
import java.io.*;

public class 연구소3 {

    static class Virus {
        int x, y, time;

        Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int N, M;
    static int[][] map;
    static int originEmptySpace = 0;
    static List<Virus> viruses = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static Virus[] active; // M개의 활성화된 바이러스들
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][N];
        active = new Virus[M];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());

                if (map[i][j] == 0) {
                    originEmptySpace++;
                }
                else if (map[i][j] == 2) {
                    viruses.add(new Virus(i, j, 0)); // 비활성화 바이러스를 모아둠
                }
            }
        }

        if (originEmptySpace == 0) {
            System.out.println(0);
        }
        else {
            dfs(0, 0);
            System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        }

    }

    // 백트래킹으로 M개의 바이러스를 선택하는 dfs 구현
    static void dfs(int start, int count) {
        if (count == M) {
            bfs(originEmptySpace);
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            active[count] = viruses.get(i);
            dfs(i + 1, count + 1);
        }
    }

    // 바이러스를 퍼트리기 위해 bfs 구현
    static void bfs(int emptySpace) {
        Queue<Virus> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            Virus virus = active[i];
            visited[virus.x][virus.y] = true;
            queue.add(virus);
        }

        while(!queue.isEmpty()) {
            Virus virus = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                // 범위를 벗어난 경우 continue
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                // 방문했거나 벽인 경우 continue
                if (visited[nx][ny] || map[nx][ny] == 1) continue;

                // 지역 변수인 emptySpace 값만 변경되고 전역 변수인 originEmptySpace 값은 변경되지 않는다.
                if (map[nx][ny] == 0) emptySpace--;

                // 빈 칸이 없을 경우의 최소 시간을 구해야 하므로
                // 빈 칸이 없을 때 최소 시간(virus.time + 1)을 구하고
                // 빈 칸이 없으므로 bfs를 종료한다.
                if (emptySpace == 0) {
                    answer = Math.min(answer, virus.time + 1);
                    return;
                }

                // 빈 칸(0)이고 비활성화된 바이러스(2)인 경우 Queue에 추가
                // 비활성 바이러스 칸은 BFS가 지나가면 활성화되지만,
                // 새로운 바이러스 개체가 생기는 것이 아니므로 M개 이상으로 늘지 않는다.
                visited[nx][ny] = true;
                queue.add(new Virus(nx, ny, virus.time + 1));
            }
        }
    }
}

