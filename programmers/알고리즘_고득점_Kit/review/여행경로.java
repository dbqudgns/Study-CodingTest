package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 여행경로 {

    static List<String> lists = new ArrayList<>();
    static boolean[] visited;

    public static String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(lists);

        return lists.get(0).split(" ");

    }

    public static void dfs(int depth, String start, String path, String[][] tickets) {
        if (depth == tickets.length) {
            lists.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(depth+1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String[][] tickets = new String[size][2];
        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < 2; j++) {
                tickets[i][j] = sc.next();
            }
        }

        System.out.println(Arrays.toString(solution(tickets)));
    }
}
