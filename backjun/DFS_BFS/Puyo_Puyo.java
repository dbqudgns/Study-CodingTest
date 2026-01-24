package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Puyo_Puyo {

    static class POP {
        private int count;
        private List<int[]> lists;

        public POP(int count, List<int[]> lists) {
            this.count = count;
            this.lists = lists;
        }
    }

    static char[][] map;
    static boolean[][] visited;
    static List<POP> addLinked = new ArrayList<>();
    static int answer = 0;
    static int cnt = 0;

    static int[] dx = {1, -1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우

    public static void main(String[] args) throws IOException {

        map = new char[12][6];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        boolean isPop = true;
        while(isPop) {

            addLinked.clear();
            isPop = false;
            visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {

                        cnt = 1;
                        List<int[]> add = new ArrayList<>();
                        add.add(new int[]{i, j});
                        visited[i][j] = true;

                        dfs(i, j, add);

                        if (cnt >= 4) {
                            POP pop = new POP(cnt, add);
                            addLinked.add(pop);
                            isPop = true;
                        }

                    }
                }
            }

            if (isPop) {
                answer++;
                gravity();
            }
        }

        System.out.println(answer);
    }

    public static List<int[]> dfs(int x, int y, List<int[]> add) {

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= 12 || nextY >= 6) {
                continue;
            }

            if (!visited[nextX][nextY] && map[x][y] == map[nextX][nextY]) {
                visited[nextX][nextY] = true;
                add.add(new int[]{nextX, nextY});
                cnt++;
                dfs(nextX, nextY, add);
            }
        }

        return add;
    }

    public static void gravity() {

        for (int i = 0; i < addLinked.size(); i++) {
            POP pop = addLinked.get(i);

            for (int j = 0; j < pop.lists.size(); j++) {
                int[] get = pop.lists.get(j);
                map[get[0]][get[1]] = '.';
            }
        }

        for (int j = 0; j < 6; j++) {

            Queue<Character> queue = new ArrayDeque<>();

            // 1. 아래(11)에서 부터 위(0)까지 . 제외 가져오기
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] != '.') {
                    queue.add(map[i][j]);
                }
            }

            // 2. 해당 열 빈 칸으로 만들기
            for (int i = 0; i < 12; i++) {
                map[i][j] = '.';
            }

            // 큐에 담아둔 Puyo를 아래 11행부터 채워 놓음
            int row = 11;
            while(!queue.isEmpty()) {
                map[row][j] = queue.poll();
                row--;
            }

        }
    }
}