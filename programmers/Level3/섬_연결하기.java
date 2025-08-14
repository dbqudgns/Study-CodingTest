package Level3;

import java.util.*;

// 가장 최소의 비용으로 모든 다리를 연결하여야 하므로 최소 신장 트리(MST)를 구하는 문제이다.
// 최소 신장 트리를 구하기 위해 크루스칼 알고리즘을 활용
public class 섬_연결하기 {

    static int[] parent; // 각 섬의 부모 노드를 저장하는 배열 (Union-Find 구조)

    // 특정 섬의 부모 찾기 (경로 압축)
    public static int find(int a) {
        if (parent[a] == a) return a; // 자기 자신이 부모면 그대로 반환
        else return parent[a] = find(parent[a]); // 아니면 부모를 재귀적으로 찾아서 갱신
    }

    // 두 섬을 연결 (Union 연산)
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a; // b의 부모를 a로 설정
    }

    public static int solution(int n, int[][] costs) {

        // 1. 부모 배열 초기화 (처음에는 자기 자신이 부모)
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 2. 다리 건설 비용을 오름차순으로 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        int result = 0; // 최소 비용 합계

        // 3. 비용이 낮은 순서대로 간선 선택
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0]; // 섬 A
            int b = costs[i][1]; // 섬 B
            int val = costs[i][2]; // 비용

            // 4. 사이클이 생기지 않는 경우에만 연결
            if (find(a) != find(b)) {
                union(a, b); // 두 섬 연결
                result += val; // 비용 추가
            }
        }

        return result; // 최소 비용 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int costs_size = sc.nextInt();
        int[][] costs = new int[costs_size][3];

        for (int i = 0; i < costs_size; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                costs[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(n, costs));
    }

}
