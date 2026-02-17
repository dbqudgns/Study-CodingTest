package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_12 {

    static int N, M;
    static int[] array;
    static int[] answer;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        array = new int[N];
        answer = new int[M];

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(array);

        sb = new StringBuilder();

        solution(0, 0);

        System.out.println(sb);
    }

    public static void solution(int startIndex, int depth) {

        // 기저 조건
        if (depth == M) {
            for (int num : answer) {
                sb.append(num).append(" ");
            }
            sb.append("\n");

            return;
        }

        // 수행
        int begin = 0;
        for (int i = startIndex; i < N; i++) {
            if (begin != array[i]) {
                begin = array[i];
                answer[depth] = array[i];
                solution(i, depth + 1);
            }
        }
    }
}