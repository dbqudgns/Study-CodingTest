package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 피로도 {

    static int answer = 0;

    public static int solution(int k, int[][] dungeons) {

        boolean[] visited = new boolean[dungeons.length];

        dfs(k, 0, dungeons, visited);

        return answer;

    }

    // k : 남은 피로도
    public static void dfs(int k, int count, int[][] dungeons, boolean[] visited) {

        answer = Math.max(count, answer);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], count+1, dungeons, visited);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int size = sc.nextInt();

        int[][] dungeons = new int[size][2];
        for (int i = 0; i < dungeons.length; i++) {
            for (int j = 0; j < 2; j++) {
                dungeons[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(k, dungeons));
    }

}
