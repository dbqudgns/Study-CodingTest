package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 네트워크 {

    public static int solution(int n, int[][] computers) {

        int answer = 0;
        boolean[] visited = new boolean[computers.length];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(computers, visited, i);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int[][] computers, boolean[] visited, int main_computer) {

        visited[main_computer] = true;

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[main_computer][i] == 1) {
                dfs(computers, visited, i);
            }
        }
    }

    public static void bfs(int[][] computers, boolean[] visited, int main_computer) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(main_computer);
        visited[main_computer] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < computers.length; i++) {
                if (computers[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] computers = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                computers[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(n, computers));
    }

}
