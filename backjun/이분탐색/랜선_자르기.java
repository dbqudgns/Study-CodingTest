package 이분탐색;

import java.util.*;
import java.io.*;

public class 랜선_자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(token.nextToken()); // 오영식이 가지고 있는 랜선 개수 K
        int N = Integer.parseInt(token.nextToken()); // 필요한 랜선 개수 N

        long[] lineLength = new long[K];
        for (int i = 0; i < K; i++) {
            lineLength[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lineLength);
        long left = 1;
        long right = lineLength[K-1];

        long answer = 0;
        while (left <= right) {

            long mid = (left + right) / 2;

            int sumCount = 0;
            for (int i = 0; i < K; i++) {
                long count = lineLength[i] / mid;
                sumCount += count;
            }

            // 특정 길이일 때 개수가 N개 이상이다?
            if (sumCount >= N) {
                answer = mid;
                left = mid + 1; // mid보다 더 긴 길이 시도해보자
            }
            // 특정 길이일 때 개수가 N개 미만이다?
            else {
                right = mid - 1; // mid가 너무 크니까 더 짧게 잘라보자
            }
        }

        System.out.println(answer);
    }

}
