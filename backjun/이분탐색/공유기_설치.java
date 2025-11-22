package 이분탐색;

import java.util.*;
import java.io.*;

public class 공유기_설치 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int low = 1; // 가능한 최소 간격
        int high = arr[n-1]; // 입력받은 집들의 최대 간격
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2; // 최소 거리 설정

            int position = 0; // 공유기 설치 위치(처음부터 시작)
            int cnt = 1; // 설치 가능한 공유기 수 (처음 집에 설치했으므로 1부터 시작)
            for (int i = 1; i < n; i++) {
                /** position번째 공유기를 설치한 집으로부터 최소거리(mid) 이상의
                 * 거리를 두고 있는 집(들)에 cnt+1번째 공유기를 설치한다.
                 */
                if (arr[i] - arr[position] >= mid) {
                    position = i;
                    cnt++;
                }
            }

                // 설치된 공유기 수가 가지고 있는 공유기의 수보다 적다는 것은
                // 최소 거리를 크게 설정해서 가지고 있는 공유기를 다 못 쓴다.
                if (cnt < c) {
                    high = mid - 1; // 최소거리를 줄인다.
                    continue;
                }

                // 설치된 공유기 수가 가지고 있는 공유기 수보다 크거나 같다는 것은
                // 최소 거리를 작게 설정해서 가지고 있는 공유기보다 더 많은 양을 설치하게 된다. => 최소거리를 늘린다.
                // 하지만, 설치된 수 == 가지고 있는 수는 우리가 결국 구해야 하는 상황인 최소 거리가 최대일 때인지 알 수 없기 때문에 최소 거리를 늘린다.
                low = mid + 1; // 최소 거리를 늘린다.
                answer = mid;
        }

        System.out.println(answer);
    }

}
