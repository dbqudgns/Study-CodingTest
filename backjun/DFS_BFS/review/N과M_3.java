package DFS_BFS.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_3 {

    static int N, M, array[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        array = new int[M];

        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int depth) {

        if (depth == M) {
            for (int i = 0; i < depth; i++) {
                sb.append(array[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= N; i++) {
            array[depth] = i;
            dfs(depth + 1);
        }
    }
}