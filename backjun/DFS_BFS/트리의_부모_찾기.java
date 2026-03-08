package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의_부모_찾기 {

    /** 틀린 코드
    static List<List<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeSize = Integer.parseInt(br.readLine());
        StringTokenizer token;

        // 1. 0부터 N 노드의 list를 초기화
        for (int i = 0; i <= nodeSize; i++) {
            List<Integer> list = new ArrayList<>();
            tree.add(i, list);
        }

        for (int i = 1; i <= nodeSize-1; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            // 2. 입력으로 주어진 a, b 노드에 대하여 a, b 두 개중 하나라도 1이 있으면 1 노드에 바로 연결
            if (a == 1) {
                List<Integer> listOne = tree.get(1);
                listOne.add(b);
            } else if (b == 1) {
                List<Integer> listOne = tree.get(1);
                listOne.add(a);
            }
            // 3. 근데 둘 다 1이 아니라면 1의 자식들 중에 a, b와 일치하는 값이 있다면 연결시킨다.
            else {

                List<Integer> listOne = tree.get(1);
                for (int j = 0; j < listOne.size(); j++) {
                    int child = listOne.get(j);
                    List<Integer> childTree = tree.get(child);

                    if (a == child) childTree.add(b);
                    else if (b == child) childTree.add(a);
                }

            }
        }

        // 4. 1 노드의 list부터 자식 노드의 부모를 answer 배열에 추가
        int[] answer = new int[nodeSize];
        for (int i = 1; i < tree.size(); i++) {
            List<Integer> list = tree.get(i);

            for (int j = 0; j < list.size(); j++) {
                int num = list.get(j);
                answer[num - 1] = i;
            }
        }

        // 5. StringBuilder 통해 출력
        StringBuilder sb = new StringBuilder();
        for (int num = 1; num < answer.length; num++) {
            sb.append(answer[num]).append("\n");
        }

        System.out.println(sb);
    }
     */

    static List<List<Integer>> tree = new ArrayList<>();
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeSize = Integer.parseInt(br.readLine());

        // 1. 트리 구조를 저장할 인접 리스트 생성
        for (int i = 0; i <= nodeSize; i++) {
            tree.add(new ArrayList<>());
        }

        // 2. 간선 정보 입력받아 양방향으로 연결하기
        for (int i = 0; i < nodeSize - 1; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // 3. 부모를 저장할 배열과 방문 여부룰 체크할 배열
        parent = new int[nodeSize + 1];
        visited = new boolean[nodeSize + 1];


        // 4.1 DFS 탐색 시작
        visited[1] = true;
        dfs(1);

        // 4.2 BFS 탐색 시작
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : tree.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = current;
                    queue.add(next);
                }
            }
        }

        // 5. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= nodeSize; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int current) {
        for (int next : tree.get(current)) {
            if (!visited[next]) {
                visited[next] = true;
                parent[next] = current;
                dfs(next);
            }
        }
    }


}