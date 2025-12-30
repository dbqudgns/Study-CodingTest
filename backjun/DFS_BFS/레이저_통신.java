package DFS_BFS;

import java.util.*;
import java.io.*;

public class 레이저_통신 {

    static char[][] map;
    // 수정 1: 방향별로 최소 거울 개수를 저장하기 위해 3차원 배열 사용
    static int[][][] minMirrors;
    static int answer = Integer.MAX_VALUE;
    static List<int[]> Clist = new ArrayList<>();
    static int W, H;

    // 동서남북
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    // 동서남북
    static int[] dd = {1, 2, 3, 4};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        W = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());

        map = new char[H][W];
        minMirrors = new int[H][W][4];

        for (int i = 0; i < H; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                map[i][j] = charArray[j];

                // 수정 2: 3차원 배열 초기화
                for (int k = 0; k < 4; k++) {
                    minMirrors[i][j][k] = Integer.MAX_VALUE;
                }

                if (map[i][j] == 'C') {
                    Clist.add(new int[]{i, j});
                }
            }
        }

        bfs();
        System.out.println(answer);
    }

    public static void bfs() {

        // 수정 3: 거울 개수가 적은 순서대로 정렬되는 우선순위 큐 사용
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[3] - o2[3];
            }
        });

        int[] firstC = Clist.get(0);
        int[] secondC = Clist.get(1);

        // 수정 4: 시작점은 방향이 없지만, 상하좌우 어디로든 뻗어나갈 수 있도록
        // 4방향 모두 큐에 넣는다.
        for (int i = 0; i < 4; i++) {
            queue.add(new int[]{firstC[0], firstC[1], i, 0});
            minMirrors[firstC[0]][firstC[1]][i] = 0;
        }

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];
            int curDir = poll[2]; // 동서남북:0123
            int count = poll[3];

            if (curX == secondC[0] && curY == secondC[1]) {
                answer = Math.min(answer, count);
                continue; // 도착했어도 다른 경로가 더 짧을 수 있으니 continue;
            }

            for (int i = 0; i < 4; i++) {
                int moveX = dx[i] + curX;
                int moveY = dy[i] + curY;
                int nextCount = count;

                if (moveX < 0 || moveY < 0 || moveX >= H || moveY >= W) continue;

                // 수정 5: 방향이 다르면 거울 추가
                if (curDir != i) nextCount++;

                // 수정 6: 해당 지점에 해당 방향으로 도달했을 때의 비용이 더 작을 때만 갱신한다.
                if (minMirrors[moveX][moveY][i] > nextCount) {
                    minMirrors[moveX][moveY][i] = nextCount;
                    queue.add(new int[]{moveX, moveY, i, nextCount});
                }
            }
        }
    }
}