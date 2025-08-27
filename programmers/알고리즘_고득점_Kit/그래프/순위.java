package 알고리즘_고득점_Kit.그래프;

import java.util.*;

public class 순위 {

    public static int solution(int n, int[][] results) {
        int answer = 0;

        // 1. 승패 여부를 기록할 2차원 배열 선언
        // win[a][b] = true -> a선수가 b선수를 이겼다.
        // lose[a][b] = true -> a선수가 b선수에게 졌다.
        boolean[][] win = new boolean[n+1][n+1];
        boolean[][] lose = new boolean[n+1][n+1];

        // 2. 주어진 결과를 win/lose 배열에 반영
        for (int[] r : results) {
            win[r[0]][r[1]] = true; // r[0]가 r[1]를 이겼다.
            lose[r[1]][r[0]] = true; // r[1]가 r[0]에게 졌다.
        }

        // 3. 플로이드-와샬 알고리즘을 통해 간접 승패 관계 채우기
        // k를 거쳐가는 경우를 확인하면서 i -> j 승패 관계를 알 수 있다.
        for (int k = 1; k <= n; k++) { // k : 중간 선수
            for (int i = 1; i <= n; i++) { // i : 출발 선수
                for (int j = 1; j <= n; j++) { // j : 도착 선수

                    // i가 k를 이기고, k가 j를 이긴다면 i가 j도 이긴다.
                    if(win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }

                    // i가 k에게 지고, k가 j에게 졌다면 i가 j에게도 진다.
                    if(lose[i][k] && lose[k][j]) {
                        lose[i][j] = true;
                    }

                }
            }
        }

        // 4. 각 선수별로 "자신과 직접 또는 간접적으로 연결된 선수 수"를 계산
        // 만약 어떤 선수가 다른 n-1명과 모두 승패 관계가 확실히 정해졌다면 순위 확정이 가능하다.
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (win[i][j] || lose[i][j]) cnt++;
            }

            if (cnt == n-1) answer++; // 모든 선수와 승패 관계가 명확해진다면 순위 결정 가능하다.
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int results_size = sc.nextInt();
        int[][] results = new int[results_size][2];

        for (int i = 0; i < results_size; i++) {
            for (int j = 0; j < 2; j++) {
                results[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(n, results));
    }
}
