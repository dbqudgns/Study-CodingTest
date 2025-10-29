package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 전력망을_둘로_나누기 {

    static List<List<Integer>> lists;

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // 1번부터 n번까지 사용하므로 n+1
            lists.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int left = wire[0];
            int right = wire[1];

            lists.get(left).add(right);
            lists.get(right).add(left);
        }

        for (int[] wire : wires) {
            int left = wire[0];
            int right = wire[1];

            lists.get(left).remove(Integer.valueOf(right));
            lists.get(right).remove(Integer.valueOf(left));

            int left_answer = bfs(left, n);
            int right_answer = bfs(right, n);

            answer = Math.min(answer, Math.abs(left_answer - right_answer));

            lists.get(left).add(right);
            lists.get(right).add(left);
        }

        return answer;
    }

    public static int bfs(int start, int n) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];

        visited[start] = true;
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(start);

        while(!queue.isEmpty()) {
            int nowNode = queue.poll();

            for (int i = 0; i < lists.get(nowNode).size(); i++) {
                int nextNode = lists.get(nowNode).get(i);

                if (visited[nextNode]) continue;

                answer++;
                visited[nextNode] = true;
                queue.add(nextNode);
            }
        }

        return answer + 1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] wires = new int[n-1][2];

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < 2; j++) {
                wires[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(n, wires));
    }

}
