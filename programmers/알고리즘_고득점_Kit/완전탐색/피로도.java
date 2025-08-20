// 완점 탐색 : BFS
package 알고리즘_고득점_Kit.완전탐색;

import java.util.*;

public class 피로도 {
    static int maxCount = 0;

    public static int solution(int k, int[][] dungeons) {

        boolean[] visited = new boolean[dungeons.length];

        dfs(k,0, dungeons, visited);

        return maxCount;
    }

    public static void dfs(int remain_K, int count, int[][]dungeons, boolean[] visited) {

        // 던전을 도는 횟수를 카운트하고 각 카운트 값을 비교하여 큰 값을 반환
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < dungeons.length; i++) {
            // 해당 던전을 반환하지 않고 현재 피로도가 해당 던전 피로도보다 크거나 같을 때
            if (!visited[i] && dungeons[i][0] <= remain_K) {
                visited[i] = true; // 방문했다.
                dfs(remain_K - dungeons[i][1], count+1, dungeons, visited);
                visited[i] = false; // 방문하지 않았다.
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[][] dungeons = new int[x][y];

        for(int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                dungeons[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(k, dungeons));

    }

}
