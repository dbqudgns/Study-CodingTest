package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스타트와_링크 {

    static int N;
    static int[][] map;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static List<Integer> start = new ArrayList<>();
    static List<Integer> link = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int index) {

        // 스타트 안에 개수가 N/2이 아니라면
        if (start.size() != N / 2) {
            for (int i = index; i < N; i++) {
                if (!visited[i]) {
                    start.add(i);
                    visited[i] = true;
                    dfs(i + 1);
                    start.remove((Integer) i);
                    visited[i] = false;
                }
            }
        }
        // 스타트 안에 개수가 N/2이라면, 나머지를 링크에 넣는다.
        else {
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    link.add(i);
                }
            }
            abilityCal();
            link.clear();
        }
    }

    public static void abilityCal() {

        int startSum = 0;
        for (int i = 0; i < start.size(); i++) {
            for (int j = i+1; j < start.size(); j++) {
                startSum += map[start.get(i)][start.get(j)] + map[start.get(j)][start.get(i)];
            }
        }

        int linkSum = 0;
        for (int i = 0; i < link.size(); i++) {
            for (int j = i+1; j < link.size(); j++) {
                linkSum += map[link.get(i)][link.get(j)] + map[link.get(j)][link.get(i)];
            }
        }

        int abs = Math.abs(startSum - linkSum);
        answer = Math.min(answer, abs);
    }
}