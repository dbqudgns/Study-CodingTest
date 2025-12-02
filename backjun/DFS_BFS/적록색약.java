package DFS_BFS;

import java.io.*;

public class 적록색약 {

    static int N;
    static boolean[][] visited;
    static int[] mx = {-1, 1, 0, 0}; // 상하좌우
    static int[] my = {0, 0, -1, 1}; // 상하좌우
    static int red, blue, green = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 적록색약이 아닌 사람의 관점
        visited = new boolean[N][N];
        int noColorPerson = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (!visited[i][j]) {
                    char color = map[i][j];
                    dfs(i, j, color, map);

                    if (color == 'R') red++;
                    else if (color == 'B') blue++;
                    else if (color == 'G') green++;
                }
            }
        }

        noColorPerson = red + blue + green;

        // 적록색약인 사람의 관점
        visited = new boolean[N][N];
        red = 0;
        blue = 0;
        int colorPerson = 0;

        char[][] mapRG = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') mapRG[i][j] = 'R';
                else mapRG[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (!visited[i][j]) {
                    char color = mapRG[i][j];
                    dfs(i, j, color, mapRG);

                    if (color == 'R') red++;
                    else if (color == 'B') blue++;
                }
            }
        }

        colorPerson = red + blue;

        System.out.println(noColorPerson + " " + colorPerson);

    }

    public static void dfs(int x, int y, char color, char[][] map) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {

            int dx = x + mx[i];
            int dy = y + my[i];

            if (dx < 0 || dy < 0 || dx >= N || dy >= N) continue;

            if (!visited[dx][dy] && map[dx][dy] == color) {
                dfs(dx, dy, color, map);
            }
        }

    }

}
