package DFS_BFS.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 감소하는_수 {

    static List<Long> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 9; i++) {
            dfs(i);
        }

        Collections.sort(lists);

        if (N >= lists.size()) System.out.println(-1);
        else System.out.println(lists.get(N));
    }

    public static void dfs(long value) {
        lists.add(value);

        long scale = value % 10;
        for (int i = 0; i < scale; i++) {
            dfs(value * 10 + i);
        }
    }
}
