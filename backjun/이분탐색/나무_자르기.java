package 이분탐색;

import java.util.*;
import java.io.*;

public class 나무_자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        long[] tree = new long[N];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(token.nextToken());
        }

        Arrays.sort(tree);
        long left = 0; // 톱날의 최소 높이
        long right = tree[N-1]; // 톱날의 최대 높이

        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            long treeSum = 0;
            for (int i = 0; i < N; i++) {
                long value = tree[i] - mid;
                if (value <= 0) value = 0;

                treeSum += value;
            }

            // treeSum >= M ?
            // => 지금 mid로도 되지만 적어도 m미터인 최대 높이를 구해야 하니까
            if (treeSum >= M) {
                answer = mid;
                left = mid + 1;
            }
            // treeSum < M ?
            // => 지금 mid로는 나무가 부족하니 톺날 높이를 낮춰야 한다.
            else {
                right = mid - 1;
            }

        }
        System.out.println(answer);
    }

}
