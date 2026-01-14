package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자_끼워넣기 {

    static int N;
    static int[] num;
    static char[] oper = {'+', '-', '*', '/'};

    static int small = Integer.MAX_VALUE;
    static int big = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(token.nextToken());
        }

        int[] count = new int[4];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            count[i] = Integer.parseInt(token.nextToken());
        }

        dfs(num[0], 1, count);
        System.out.println(big);
        System.out.println(small);
    }

    public static void dfs(int value, int nextIndex, int[] count) {
        int number = 0;
        for (int i = 0; i < 4; i++) {
            if (count[i] != 0) break;
            number++;
        }

        if (number == 4 || nextIndex == N) {
            small = Math.min(small, value);
            big = Math.max(big, value);
            return;
        }


        for (int j = 0; j < 4; j++) {
            if (count[j] > 0) {
                switch (oper[j]) {
                    case '+' :
                        count[j] -= 1;
                        dfs(value + num[nextIndex], nextIndex + 1, count);
                        count[j] += 1;
                        break;
                    case '-' :
                        count[j] -= 1;
                        dfs(value - num[nextIndex], nextIndex + 1, count);
                        count[j] += 1;
                        break;
                    case '*' :
                        count[j] -= 1;
                        dfs(value * num[nextIndex], nextIndex + 1, count);
                        count[j] += 1;
                        break;
                    case '/' :
                        count[j] -= 1;

                        if (value < 0) {
                            value = Math.abs(value);
                            dfs((value / num[nextIndex]) * -1, nextIndex + 1, count);
                            value = -1 * value;
                        }
                        dfs(value / num[nextIndex], nextIndex + 1, count);

                        count[j] += 1;
                        break;
                }
            }
        }
    }
}
