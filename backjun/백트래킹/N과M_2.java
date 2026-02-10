package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N과M_2 {

    static StringBuilder sb;
    static List<Integer> lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        sb = new StringBuilder();
        lists = new ArrayList<>();

        dfs(N, M, 1);
        System.out.print(sb);
    }

    public static void dfs(int N, int M, int start) {

        // 1. 기저 조건 : lists의 크기가 M가 같을 때 return
        if (lists.size() == M) {
            for (int i = 0; i < M; i++) {
                sb.append(lists.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 2. for문으로 lists에 add하기
        for (int i = start; i <= N; i++) {
            lists.add(i);
            dfs(N, M, i + 1);
            lists.remove((Integer) i);
        }
    }
}