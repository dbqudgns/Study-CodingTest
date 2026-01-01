    package D2;

    import java.util.Scanner;

    public class 파리퇴치3 {

        public static void main(String args[]) throws Exception {
            Scanner sc = new Scanner(System.in);
            int T;
            T=sc.nextInt();

            for(int test_case = 1; test_case <= T; test_case++) {
                int N = sc.nextInt();
                int[][] map = new int[N][N];

                int M = sc.nextInt();

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        map[i][j] = sc.nextInt();
                    }
                }

                int curTop = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        int value = solution(map, i, j, N, M);
                        curTop = Math.max(curTop, value);
                    }
                }

                System.out.println("#" + test_case + " " + curTop);
            }
        }

        public static int solution(int[][] map, int x, int y, int N, int M) {

            int plusNum = map[x][y];
            int xNum = map[x][y];

            // +
            for (int i = 1; i < M; i++) {
                if (x-i >= 0) plusNum += map[x-i][y];
                if (x+i < N) plusNum += map[x+i][y];
                if (y-i >= 0) plusNum += map[x][y-i];
                if (y+i < N) plusNum += map[x][y+i];
            }

            // x
            for (int i = 1; i < M; i++) {
                if (x-i >= 0 && y-i >= 0) xNum += map[x-i][y-i];
                if (x-i >= 0 && y+i < N) xNum += map[x-i][y+i];
                if (x+i < N && y-i >= 0) xNum += map[x+i][y-i];
                if (x+i < N && y+i < N) xNum += map[x+i][y+i];
            }

            return Math.max(plusNum, xNum);
        }
    }