package D4;

import java.util.*;

public class 장훈이의_높이_선반 {
    static int N, B;
    static int[] array;
    static int min;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            array = new int[N];

            min  = Integer.MAX_VALUE;
            B = sc.nextInt();

            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }

            dfs(0, 0);

            System.out.println("#" + test_case + " " + min);
        }
    }

    public static void dfs(int start, int sum) {

        if (sum >= B) {
            int sub = sum - B;
            min = Math.min(min, sub);
            return;
        }

        if (start == N) return;

        dfs(start+1, sum + array[start]);
        dfs(start+1, sum);
    }
}