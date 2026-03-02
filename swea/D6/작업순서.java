package D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 작업순서 {

    /** 일반 구현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        for (int index = 1; index <= 10; index++) {

            String answer = "";
            token = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(token.nextToken());
            int E = Integer.parseInt(token.nextToken());

            // 1. 각 정점별로 리스트 초기화
            List<List<Integer>> lists = new ArrayList<>();
            for (int j = 0; j <= V; j++) {
                lists.add(new ArrayList<>());
            }

            // 2. 간선 추가 (유방향 그래프)
            token = new StringTokenizer(br.readLine());
            for (int j = 1; j <= E; j++) {

                int before = Integer.parseInt(token.nextToken());
                int last = Integer.parseInt(token.nextToken());

                lists.get(last).add(before);
            }

            boolean[] visited = new boolean[V+1];
            int num = 0;

            // 3. 선행 정보가 없는 작업들을 찾아보자.
            for (int j = 1; j <= V; j++) {
                List<Integer> getList = lists.get(j);
                if (getList.isEmpty()) {
                    visited[j] = true;
                    num++;
                    answer += j + " ";
                }
            }

            // 4. 선행 정보가 있는 작업들을 처리해보자
            while(num != V) {
                for (int i = 1; i <= V; i++) {
                    if (!visited[i]) {

                        List<Integer> getList = lists.get(i);

                        int count = 0;
                        for (int j = 0; j < getList.size(); j++) {
                            int idx = getList.get(j);
                            if (visited[idx]) {
                                count++;
                            }
                        }

                        if (count == getList.size()) {
                            visited[i] = true;
                            num++;
                            answer += i + " ";
                        }
                    }
                }
            }

            System.out.println("#" + index + " " + answer);
        }
    }
     */

    /** 위상정렬을 이용한 풀이 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int index = 1; index <= 10; index++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(token.nextToken());
            int E = Integer.parseInt(token.nextToken());

            // 1. 그래프 초기화 (선행 작업 -> 후행 작업 방향으로 연결)
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            // 2. 진입차수 배열 초기화 (자신을 가리키는 화살표 개수)
            int[] inDegree = new int[V + 1];

            token = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int from = Integer.parseInt(token.nextToken());
                int to = Integer.parseInt(token.nextToken());

                graph.get(from).add(to); // 방향 그래프 간선 연결
                inDegree[to]++; // 후행 작업의 진입차수 1 증가
            }

            // 3. 위상정렬을 위한 큐 생성 및 초기화
            Queue<Integer> queue = new LinkedList<>();

            // 처음 시작할 때 진입차수가 0인(선행 작업이 없는) 정점을 모두 큐에 삽입
            for (int i = 1; i <= V; i++) {
                if (inDegree[i] == 0) queue.offer(i);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(index).append(" ");

            // 4. 큐에서 하나씩 꺼내며 위상 정렬 수행
            while (!queue.isEmpty()) {
                int current = queue.poll();
                sb.append(current).append(" "); // 꺼낸 정점은 작업이 완료된 것이므로 결과에 추가

                // 현재 작업과 연결된 다음 작업들의 진입차수를 1씩 감소
                for (int next : graph.get(current)) {
                    inDegree[next]--;

                    // 새롭게 진입차수가 0이 된(선행 작업이 모두 끝난) 정점을 큐에 삽입
                    if (inDegree[next] == 0) queue.offer(next);
                }
            }

            System.out.println(sb.toString().trim());
        }
    }
}