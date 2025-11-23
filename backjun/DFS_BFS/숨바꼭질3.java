package DFS_BFS;

import java.util.*;
import java.io.*;

public class 숨바꼭질3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        boolean[] visited = new boolean[100001];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});

        int answer = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];
            int time = poll[1];

            if (current == K) {
                answer = Math.min(answer, time);
            }

            /**
             * 만약 큐에 넣을 때 visited = true를 설정하면
             * 나중에 발견되는 더 빠른 경로(순간이동)를 막아버리기 때문에
             * N=2, K=7에서 최단 시간 1초가 무시되어 2초가 되어 오답이 나온다.
             * 그러므로, 큐에서 뺏을 때 기준으로 visted = true를 설정해야 한다.
             *
             * 예를 들어, N=2, K=7에서
             * 큐에 (7,2)를 넣으면서 visited[7] = true로 설정되는데
             * queue = [(5,1), (8,0), (7,2)]
             * (8, 0)을 처리할 때 8-1=7로 총 1초로 최단 시간을 구할 수 있는데
             * 이미 visited[7]이 true로 설정되어 있으므로 최단시간 1를 구할 수가 없게 된다.
             */
            visited[current] = true;

            int currentUp = current+1;
            if (currentUp <= 100000 && !visited[currentUp]) {
                queue.add(new int[]{currentUp, time+1});
            }

            int currentDown = current-1;
            if (currentDown >= 0 && !visited[currentDown]) {
                queue.add(new int[]{currentDown, time+1});
            }

            int currentDouble = 2*current;
            if (currentDouble <= 100000 && !visited[currentDouble]) {
                queue.add(new int[]{currentDouble, time});
            }

        }

        System.out.println(answer);
    }

}
