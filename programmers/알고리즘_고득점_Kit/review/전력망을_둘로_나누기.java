package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 전력망을_둘로_나누기 {

    // 각 노드(송전탑)와 연결된 노드들을 저장할 인접 리스트 배열
    static List<Integer> [] lists;

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE; // 최소 차이를 구해야 하므로 초기값은 최대 값으로 설정
        lists = new ArrayList[n+1]; // 노드 번호는 1부터 시작하므로 n+1 크기의 배열 생성

        // 각 노드에 대해 ArrayList 초기화 (인접 노드 저장용)
        for (int i = 1; i < n+1; i++) {
            lists[i] = new ArrayList<>();
        }

        // wires 정보를 기반으로 양방향 연결 구성
        for (int i = 0; i < wires.length; i++) {
            int left = wires[i][0];
            int right = wires[i][1];

            lists[left].add(right);
            lists[right].add(left);
        }

        // 양방향 매핑 lists 확인용
        // System.out.println(Arrays.toString(lists));

        // 전선을 하나씩 끊어보면서 두 그룹으로 나누기
        for (int i = 0; i < wires.length; i++) {
            int left = wires[i][0];
            int right = wires[i][1];

            // int 형은 넣으면 인덱스로 설정돼서 해당 인덱스의 값이 제거되므로
            // Object인 Integer로 변환해 해당 값을 제거
            lists[left].remove(Integer.valueOf(right));
            lists[right].remove(Integer.valueOf(left));

            // 각 끊어진 노드에서 BFS를 돌려 몇 개의 송전탑이 연결되어 있는지 계산
            int left_answer = bfs(left, n);
            int right_answer = bfs(right, n);

            // 송전탑 수 차이의 절대 값을 구해 현재 최소값과 비교하여 갱신
            answer = Math.min(answer, Math.abs(left_answer - right_answer));

            // 끊어진 선을 다시 재연결
            lists[left].add(right);
            lists[right].add(left);
        }

        return answer;
    }

    public static int bfs(int start, int n) {
        int answer = 0; // 연결된 송전탑 개수
        // 양방향 관계인 노드들 사이에서 재호출이 일어나지 않도록 visited 배열이 필요
        boolean[] visited = new boolean[n+1];

        visited[start] = true; // 시작 노드를 방문 처리
        Queue<Integer> queue = new ArrayDeque<>(); // BFS 탐색을 위한 큐 선언

        queue.add(start);

        while(!queue.isEmpty()) {
            int nowNode = queue.poll(); // 현재 탐색할 노드를 꺼낸다.

            // 탐색할 노드에 연결된 노드들을 순회
            for (int i = 0; i < lists[nowNode].size(); i++) {
                int nextNode = lists[nowNode].get(i); // 연결된 다음 노드

                // 이미 방문한 노드는 무시
                if (visited[nextNode]) continue;

                answer++;
                visited[nextNode] = true;
                queue.add(nextNode);
            }
        }
        return answer+1; // 자기 자신을 포함해서 반환
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
