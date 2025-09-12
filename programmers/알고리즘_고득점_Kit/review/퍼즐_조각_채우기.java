package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 퍼즐_조각_채우기 {

    // 왼쪽 상단부터 좌표가 시작 : 상/우/하/좌
    static int[] dx= {-1, 0, 1, 0}; // 행
    static int[] dy = {0, 1, 0, -1}; // 열

    public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        // 방문 체크용 배열
        boolean[][] visitedTable = new boolean[table.length][table.length];
        boolean[][] visitedBoard = new boolean[game_board.length][game_board.length];

        // 추출된 퍼즐/빈칸 모양을 담을 리스트
        List<List<int[]>> boardList = new ArrayList<>();
        List<List<int[]>> tableList = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                // 퍼즐 조각 찾기
                if (table[i][j] == 1 && !visitedTable[i][j])
                    bfs(i, j, visitedTable, table, 1, tableList);
                // 빈칸 찾기
                if (game_board[i][j] == 0 && !visitedBoard[i][j])
                    bfs(i, j, visitedBoard, game_board, 0, boardList);
            }
        }

        // 테이블 퍼즐과 게임보드 빈칸을 비교행 맞는 조각 합 계산
        answer = findBlock(boardList, tableList);
        return answer;
    }

    // BFS로 연결된 퍼즐 조각/빈칸 모양을 추출하여 리스트에 추가
    public static void bfs(int currentX, int currentY, boolean[][] visited, int[][] graph,
                           int blockOrEmpty, List<List<int[]>> list) {

        Queue<int[]> queue = new LinkedList<>();
        visited[currentX][currentY] = true;
        queue.add(new int[] {currentX, currentY});

        // 상대 좌표 기준으로 모양 저장
        List<int[]> subList = new ArrayList<>();
        subList.add(new int[]{0, 0}); // 시작점 기준 (0,0)

        while(!queue.isEmpty()) {
            int[] pop = queue.remove();
            int popX = pop[0];
            int popY = pop[1];

            for (int i = 0; i < 4; i++) {
                int nextX = popX + dx[i];
                int nextY = popY + dy[i];

                // 범위 체크
                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph.length) continue;

                // 아직 방문 안했고 동일한 값(0또는 1)이면
                if (!visited[nextX][nextY] && graph[nextX][nextY] == blockOrEmpty) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});

                    // 시작점 기준으로 상대 좌표 저장
                    subList.add(new int[]{nextX - currentX, nextY - currentY});
                }
            }
        }

        list.add(subList); // 하나의 모양으로 저장
    }

    // 퍼즐 조각과 보드 빈칸을 비교해서 맞는 조각을 채우고 총 개수 반환
    public static int findBlock(List<List<int[]>> board, List<List<int[]>> table) {
        int size = 0;
        int tableLen = table.size();
        int boardLen = board.size();
        boolean[] visitedBoard = new boolean[boardLen]; // 사용한 빈칸 체크

        for (int i = 0; i < tableLen; i++) {
            List<int[]> tablePoints = table.get(i); // i번째 퍼즐 조각

            for (int j = 0; j < boardLen; j++) {
                List<int[]> boardPoints = board.get(j); // j번째 빈칸

                // 조각의 칸 수가 같고, 아직 사용 안한 빈칸이면
                if (tablePoints.size() == boardPoints.size() && !visitedBoard[j]) {
                    // 회전시켜 모양이 맞는지 확인
                    if (isRotate(boardPoints, tablePoints)) {
                        size += tablePoints.size(); // 맞으면 크기를 더함
                        visitedBoard[j] = true; // 해당 빈칸은 사용 처리
                        break;
                    }
                }
            }
        }
        return size;
    }

    // 퍼즐 조각과 빈칸이 회전으로 일치하는지 확인
    public static boolean isRotate(List<int[]> board, List<int[]> table) {
        boolean isCollect = false;

        /*
        board의 좌표들을 x(행) -> y(열) 순으로 정렬
        x(행)가 작은게 앞으로
        x가 같다면 y(열)가 작은게 앞으로
         */
        // board를 정렬하는 이유 : table에서 board와 모양은 같은데 어떤 순서로 subList가 넘어오든 비교할 수 있도록
        // board의 모양을 먼저 하나의 표준 설계도로 만들어 두는 것!!!!
        board.sort((o1, o2) -> {
            return o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]);
        });

        // 최대 4번 회전 (0, 90, 180, 270도)
        for (int i = 0; i < 4; i++) {
            // 현재 회전 상태의 table 정렬
            table.sort((o1, o2) -> {
                return o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]);
            });

            // 좌상단 기준으로 좌표 원점 정렬
            int nearZeroX = table.get(0)[0];
            int nearZeroY = table.get(0)[1];

            // 퍼즐의 좌표들을 (0, 0) 기준으로 정렬하기 위한 코드
            for (int j = 0; j < table.size(); j++) {
                table.get(j)[0] -= nearZeroX;
                table.get(j)[1] -= nearZeroY;
            }

            // board와 회전한 table 비교
            boolean isCollectPoint = true;
            for (int j = 0; j < board.size(); j++) {
                int[] boardPoint = board.get(j);
                int[] tablePoint = table.get(j);

                if (boardPoint[0] != tablePoint[0] || boardPoint[1] != tablePoint[1]) {
                    isCollectPoint = false;
                    break;
                }
            }

            // 모양이 일치하면 true 반환
            if (isCollectPoint) {
                isCollect = true;
                break;
            } else {
                // 다음 회전을 위해 조각 회전 ( 90도 회전 공식 : (x, y) -> (y, -x)) )
                for (int j = 0; j < table.size(); j++) {
                    int temp = table.get(j)[0];
                    table.get(j)[0] = table.get(j)[1];
                    table.get(j)[1] = -temp;
                }
            }
        }
        return isCollect;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[][] game_board = new int[size][size];
        int[][] table = new int[size][size];

        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[i].length; j++) {
                game_board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(game_board, table));
    }

}
