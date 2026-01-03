package D2;

import java.util.Scanner;

public class 두_개의_숫자열 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] Ai = new int[N];
            int[] Bi = new int[M];

            for (int i = 0; i < N; i++) {
                Ai[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                Bi[i] = sc.nextInt();
            }

            int[] bigNum, shortNum;
            if (N > M) {
                bigNum = Ai.clone();
                shortNum = Bi.clone();
            }
            else {
                bigNum = Bi.clone();
                shortNum = Ai.clone();
            }

            int num = solution(bigNum, shortNum);
            System.out.println("#" + test_case + " " + num);
        }
    }

    public static int solution(int[] bigNum, int[] shortNum) {

        int bigValue = 0;
        for (int i = 0; i <= bigNum.length - shortNum.length; i++) {
            int sum = 0;
            for (int j = 0; j < shortNum.length; j++) {
                sum += shortNum[j] * bigNum[i + j];
            }
            bigValue = Math.max(bigValue, sum);
        }

        return bigValue;
    }
}