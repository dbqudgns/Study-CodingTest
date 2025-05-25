// 안전 지대
package Level0.Class91_Class100;

import java.util.Scanner;

public class Class96 {

    public static int solution(int[][] board) {

        int answer = 0; // 안전 지대 개수

        // 1. board의 각 차원의 길이에 의해 총 면적 구하기
        int n = board.length;
        int[][] danger = new int[n][n]; // int 배열 초깃값 : 0

        // 2. x와 y를 기준으로 8방향 벡터 선언 / 기준 : 상 하 좌 우 왼위대 우위대 왼아대 우아대
        int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
        int[] dy = {1, -1, 0, 0, 1, 1, -1 , -1};

        // 3. 위험 지역을 벡터 기준으로 1로 표시
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++ ) {
                if (board[y][x] == 1) {
                    danger[y][x] = 1;
                    for (int d = 0; d < 8; d++) {
                        int vx = x + dx[d];
                        int vy = y + dy[d];
                        if (vx >= 0 && vx < n && vy >= 0 && vy < n ) {
                            danger[vy][vx] = 1;
                        }
                    }

                }
            }
        }

        // 4. danger 배열을 순회하여 배열 값이 0인 구역 카운트
        for (int y = 0; y < danger.length; y++) {
            for (int x = 0; x < danger[y].length; x++ ) {
                if (danger[y][x] == 0) {
                    answer++;
                }
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(board));
    }

}
