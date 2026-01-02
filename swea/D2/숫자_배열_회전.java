package D2;

import java.util.Scanner;

public class 숫자_배열_회전
{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt();
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            System.out.println("#" + test_case);
            solution(map, N);
        }
    }

    public static void solution(int[][] map, int N) {

        for (int i = 0; i < N; i++) {

            // 90도 회전
            String str90 = "";
            for (int j = 0; j < N; j++) {
                str90 += String.valueOf(map[N-j-1][i]);
            }

            // 180도 회전
            String str180 = "";
            for (int j = N-1; j>=0; j--) {
                str180 += String.valueOf(map[N-i-1][j]);
            }

            // 270도 회전
            String str270 = "";
            for (int j = 0; j < N; j++) {
                str270 += String.valueOf(map[j][N-i-1]);
            }

            System.out.println(str90 + " " + str180 + " " + str270);
        }
    }
}
