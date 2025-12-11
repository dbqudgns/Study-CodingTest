package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 섬_연결하기 {

    static int[] parent;

    // Find (부모 찾기)
    public static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    // Union (두 집합 합치기)
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    // 크루스칼 알고리즘 적용
    public static int solutionKruskal(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // 간선 비용 기준 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int value = costs[i][2];

            if (find(a) != find(b)) {
                union(a, b);
                answer += value;
            }
        }

        return answer;
    }

    /* ============================================================ */

    // 그래프의 간선 정보를 저장할 클래스
    static class Point implements Comparable<Point> {
        int node; // 연결된 섬 번호
        int cost; // 다리 건설 비용

        public Point (int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        // 우선순위 큐에서 작동된다.
        @Override
        public int compareTo(Point p) {
            // 비용이 작은 순서대로 정렬되도록 설정
            return this.cost - p.cost;
        }
    }

    // 인접 리스트 : 각 섬에서 갈 수 있는 섬과 비용을 저장
    static List<List<Point>> map = new ArrayList<>();

    // 프림 알고리즘 적용
    public static int solutionPrim(int n, int[][] costs) {

        // 1. 인접 리스트 초기화
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        // 2. 주어진 costs로 그래프 구성
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int value = costs[i][2];

            // 양방향 연결
            map.get(from).add(new Point(to, value));
            map.get(to).add(new Point(from, value));
        }

        // 3. 프림 알고리즘 시작
        boolean[] visited = new boolean[n]; // 방문 여부 저장
        PriorityQueue<Point> queue = new PriorityQueue<>(); // 최소 비용 간선 우선 선택
        queue.add(new Point(0, 0)); // 임의의 시작점(0번 섬)선택, 비용 0

        int answer = 0; // 최소 비용 합계
        while(!queue.isEmpty()) {

            // 4. 현재 가장 비용이 낮은 간선 선택
            Point cur = queue.poll();

            // 이미 방문한 섬이면 건너뛰기
            if (visited[cur.node]) continue;

            // 방문 처리
            visited[cur.node] = true;

            // 선택된 간선 비용 누적
            answer += cur.cost;

            // 5. 현재 섬에서 갈 수 있는 다른 섬들을 큐에 추가
            for (int i = 0; i < map.get(cur.node).size(); i++) {
                int next = map.get(cur.node).get(i).node;
                int cost = map.get(cur.node).get(i).cost;

                // 이미 방문한 섬이면 제외
                if (visited[next]) continue;

                // 우선순위 큐에 삽입(자동으로 최소 비용 순 정렬)
                queue.add(new Point(next, cost));
            }
        }

        // 6. 모든 섬을 연결했을 때 최소 비용 반환
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int size = sc.nextInt();
        int[][] costs = new int[size][3];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 3; j++) {
                costs[i][j] = sc.nextInt();
            }
        }

        System.out.println(solutionKruskal(n, costs));
        System.out.println(solutionPrim(n, costs));
    }

}
