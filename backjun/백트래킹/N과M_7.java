package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_7 {

    static int N, M;
    static int[] array;
    static int[] answer;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        solution(0);
        System.out.print(sb);
    }

    public static void solution(int depth) {

        // 기저 조건
        if (depth == M) {

            for (int num : answer) {
                sb.append(num).append(" ");
            }

            sb.append("\n");

            return;
        }

        // answer에 M만큼 추가하기
        for (int i = 0; i < N; i++) {
            answer[depth] = array[i];
            solution(depth + 1);
        }
    }
}