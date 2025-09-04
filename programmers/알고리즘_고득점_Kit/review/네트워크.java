package 알고리즘_고득점_Kit.review;

import java.util.*;

// DFS, BFS 풀이
public class 네트워크 {
    // DFS 풀이
//    public static int solution(int n, int[][] computers) {
//
//        boolean[] visited = new boolean[n]; // false로 초기화
//        int answer = 0;
//
//        // 1. 기준 컴퓨터가 방문되지 않았을 때 DFS로 연결된 컴퓨터 모두 방문
//        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                dfs(computers, visited, i);
//                answer++;
//            }
//        }
//
//        return answer;
//    }
//
//    public static void dfs(int[][] computers, boolean[] visited, int main_computer) {
//
//        // 2. 기준 computer를 방문 처리
//        visited[main_computer] = true;
//
//        // 3. 방문하고자 하는 컴퓨터가 방문되지 않았고 기준 컴퓨터와 연결된 컴퓨터라면 DFS를 수행한다.
//        for (int i = 0; i < computers.length; i++) {
//            if (!visited[i] && computers[main_computer][i] == 1) {
//                dfs(computers, visited, i);
//            }
//        }
//    }

    // BFS 풀이
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

    public static void bfs(int[][] computers, boolean[] visited, int main_computer) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(main_computer);
        visited[main_computer] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < computers.length; i++) {
                if (computers[node][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        queue.add(i); // node와 연결된 컴퓨터를 큐에 넣는다! -> BFS의 핵심! (너비를 우선으로 탐색한다.)
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] computers = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                computers[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(n, computers));
    }

}
