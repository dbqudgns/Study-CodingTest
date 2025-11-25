package DFS_BFS;

import java.util.*;
import java.io.*;

public class 이모티콘 {

    static boolean[][] visited = new boolean[1001][1001]; // [screen][clipboard]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        bfs(s);
    }

    public static void bfs(int s) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0, 0));
        visited[1][0] = true;

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.screen == s) {
                System.out.println(current.time);
                return;
            }

            // 1. 화면에 있는 이모티콘 클립보드에 저장
            if (!visited[current.screen][current.screen]) {
                visited[current.screen][current.screen] = true;
                queue.add(new Node(current.screen, current.screen, current.time + 1));
            }

            // 2. 클립보드에 있는 이모티콘 붙여넣기
            // 클립보드가 비어있지 않아야 하고, 붙여 넣은 개수가 s보다 적어야 하며 이전에 방문한적이 없어야 한다.
            if (current.clipboard != 0 && current.screen + current.clipboard <= s
                                       && !visited[current.screen + current.clipboard][current.clipboard]) {
                visited[current.screen + current.clipboard][current.clipboard] = true;
                queue.add(new Node(current.screen + current.clipboard, current.clipboard, current.time + 1));
            }

            // 3. 화면에 있는 이모티콘 중 하나 삭제
            // 화면의 이모티콘 개수가 0이상이어야 하고 방문하적 없어야 한다.
            if (current.screen > 0 && !visited[current.screen-1][current.clipboard]) {
                visited[current.screen - 1][current.clipboard] = true;
                queue.add(new Node(current.screen - 1, current.clipboard, current.time + 1));
            }
        }

    }

    static class Node {
        int screen;
        int clipboard;
        int time;

        public Node(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
}
