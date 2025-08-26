package 알고리즘_고득점_Kit.그래프;

import java.util.*;

public class 가장_먼_노드 {

    public static int solution(int n, int[][] vertex) {

        // 1. 그래프를 인접 리스트 형태로 저장하기 위해 리스트 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>()); // 노드 번호(1~n)에 맞게 리스트 생성
        }

        // 2. 주어진 간선 정보를 이용해서 양방향 그래프 생성
        for (int[] edge : vertex) {
            int num1 = edge[0];
            int num2 = edge[1];
            graph.get(num1).add(num2); // num1 -> num2 연결
            graph.get(num2).add(num1); // num2 -> num1 연결 (양방향)
        }

        // 3. 각 노드까지의 최단 거리 저장 배열 (초기값은 충분히 큰 값으로 설정)
        // answer[i] : 1번 노드에서 i번 노드까지의 최단 거리를 저장한다.
        int[] answer = new int[n + 1];
        Arrays.fill(answer, n+1);

        // 4. BFS 탐색을 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // 시작 노드는 1번
        answer[1] = 0; // 시작 노드까지의 거리는 0

        // 5. BFS 시작
        while(!queue.isEmpty()) {

            int node = queue.poll(); // 현재 노드 꺼내기
            for (int next : graph.get(node)) { // 현재 노드와 연결된 모든 노드 탐색
                /** 현재 node를 거쳐서 이웃 노드(next)까지 가는 거리가 기존에 기록된 거리보다 짧으면 그 값으로 갱신한다.
                 * answer[next] : 지금까지 알고 있는 1부터 next까지의 최단 거리
                 * answer[node] + 1 : 1부터 현재 node를 거쳐서 next로 가는 거리
                 */
                if (answer[next] > answer[node] + 1) {
                    answer[next] = answer[node] + 1;
                    queue.offer(next); // 큐에 추가해서 이어서 탐색
                }
            }

        }

        // 6. 거리 배열을 정렬해서 가장 먼 거리 값을 찾는다.
        Arrays.sort(answer);
        int max = answer[answer.length-2]; // 마지막 값은 사용되지 않는 0번 노드라 -2 사용하고 실제 최댓값을 반환

        // 7. 가장 먼 거리를 가진 노드의 개수 세기
        int count = 0;
        for (int i = answer.length-2; i >= 0; i--) {
            if (answer[i] != max) { // 가장 먼 거리보다 작으면 중단
                break;
            }
            count++; // 가장 먼 거리와 같으면 카운트 증가
        }

        return count;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int vertex_size = sc.nextInt();

        int[][] vertex = new int[vertex_size][2];

        for (int i = 0 ; i < vertex_size; i++) {
            for (int j = 0; j < 2; j++) {
                vertex[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(n, vertex));
    }

}
