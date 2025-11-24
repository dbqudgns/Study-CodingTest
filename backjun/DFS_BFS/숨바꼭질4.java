package DFS_BFS;

import java.util.*;
import java.io.*;

public class 숨바꼭질4 {

    static int N, K;
    static boolean[] visited;
    static int[] parent;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        visited = new boolean[100001];
        parent = new int[100001];

        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while(index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        System.out.println(answer);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        visited[N] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];
            int time = poll[1];

            if (current == K) {
                answer = time;
                return;
            }

            for (int i = 0; i < 3; i++) {

                int next = 0;
                if (i==0) {
                    next = current+1;
                }
                else if (i==1) {
                    next = current-1;
                }
                else {
                    next = 2*current;
                }

                if (next < 0 || next > 100000) continue;

                if (!visited[next]) {
                    queue.add(new int[]{next, time + 1});
                    // 이미 큐에 같은 노드가 들어갈 수 있으니 큐에 넣을 때 방문 처리를 하자
                    visited[next] = true;
                    parent[next] = current;
                }
            }
        }


    }

}
