package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 여행경로 {

    static List<String> list = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets, visited);

        Collections.sort(list);

        return list.get(0).split(" ");
    }

    public static void dfs(int depth, String start, String path, String[][] tickets, boolean[] visited) {

        if (depth == tickets.length) {
            list.add(path);
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets, visited);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String[][] tickets = new String[size][2];

        sc.nextLine();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                tickets[i][j] = sc.nextLine();
            }
        }

        System.out.println(Arrays.toString(solution(tickets)));
    }
}
