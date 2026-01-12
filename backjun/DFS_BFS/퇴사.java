package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {

    static int N;
    static boolean[] visited;
    static int[] T;
    static int[] P;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        T = new int[N];
        P = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(token.nextToken());
            P[i] = Integer.parseInt(token.nextToken());
        }

        dfs(0, 0);
        System.out.println(answer);

    }

    public static void dfs(int day, int benefit) {

        if (day >= N) {
            answer = Math.max(answer, benefit);
            return;
        }

        // 오늘 상담을 하는 경우
        if (day + T[day] <= N) {
            // 상담이 끝난 날짜로 점프, 돈 추가
            dfs(day + T[day], benefit + P[day]);
        }

        // 오늘 상담을 하지 않고 건너뛰는 경우, 다음 날로 이동
        dfs(day + 1, benefit);
    }
}