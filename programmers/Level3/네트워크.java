package Level3;

import java.util.*;

public class 네트워크 {

    public static int solution(int n, int[][] computers) {

        int answer = 0;
        List<Integer>[] lists = new ArrayList[n];
        boolean[] visited = new boolean[n];

        // 각 컴퓨터 리스트 초기화 ( 연결된 컴퓨터 저장용 )
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        // 각 컴퓨터와 연결된 컴퓨터를 담음 ( 자기 자신은 제외 )
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && i != j) {
                    lists[i].add(j);
                }
            }
        }

        // 각 컴퓨터를 순회하면서 네트워크를 찾는다.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 네트워크 중복 방지를 위해 방문되지 않는(visited[i] = false) 컴퓨터일 때 dfs를 실행한다.
                dfs(i, lists, visited);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int mainComputer, List<Integer>[] lists, boolean[] visited) {

        visited[mainComputer] = true;

        // mainComputer와 연결된 subComputer를 기준으로 또, 다른 연결된 컴퓨터를 파악하기 위해 dfs 재귀함수로 호출한다.
        for (int subComputer : lists[mainComputer]) {
            if (!visited[subComputer]) {
                dfs(subComputer, lists, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] computers = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                computers[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, computers));
    }
}
