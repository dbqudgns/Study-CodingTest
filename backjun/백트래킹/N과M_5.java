package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_5 {

    static int N, M;
    static int[] array;
    static int[] answer;
    static boolean[] visited;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        array = new int[N];
        answer = new int[M];

        visited = new boolean[N];
        sb = new StringBuilder();

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(array);
        solution(0);

        System.out.print(sb);
    }

    public static void solution(int depth) {

        // 기저 조건 : M과 depth이 같으면 백트래킹
        if (depth == M) {

            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }

            sb.append("\n");

            return;
        }

        // start(인덱스) 기준으로 시작하여 중복 순열이 발생하지 않게 visited 처리 후 재귀 호출
        for (int i = 0; i < N; i++) {

            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = array[i];
                solution(depth + 1);
                visited[i] = false;
            }
        }
    }
}