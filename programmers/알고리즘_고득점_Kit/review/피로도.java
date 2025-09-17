package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 피로도 {

    static int maxCount = 0;
    static boolean[] visited;

    public static int solution(int k, int[][] dungeons) {
        int count = 0; // 던전 방문 횟수
        visited = new boolean[dungeons.length];

        dfs(k, count, dungeons);

        return maxCount;
    }

    public static void dfs(int remain, int count, int[][] dungeons) {

        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && remain >= dungeons[i][0]) {
                visited[i] = true;
                dfs(remain - dungeons[i][1], count+1, dungeons);
                visited[i] = false; // 백트래킹
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int size = sc.nextInt();
        int[][] dungeons = new int[size][2];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                dungeons[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(k, dungeons));

    }

}
