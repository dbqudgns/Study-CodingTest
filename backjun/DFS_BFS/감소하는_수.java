package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 감소하는_수 {

    static List<Long> lists = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 9; i++) {
            dfs(i);
        }

        Collections.sort(lists);

        if (N >= lists.size()) System.out.println(-1);
        else System.out.println(lists.get(N));
    }

    public static void dfs(long num) {
        lists.add(num);
        long finalInteger = num % 10;

        for (int i = 0; i < finalInteger; i++) {
            dfs(num * 10 + i);
        }
    }
}