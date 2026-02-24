package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가장긴증가하는부분수열4 {

    static int N;
    static int[] array;
    static int[] dp; // 각 인덱스 별 가질 수 있는 최대 부분 수열 개수
    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        array = new int[N+1];
        dp = new int[N+1];
        map = new HashMap<>();

        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        // 1. 모든 인덱스의 기본 DP 값을 1로, Map에는 자기 자신만 포함되도록 초기화
        for (int i = 1; i < N + 1; i++) {
            dp[i] = 1;
            List<Integer> init = new ArrayList<>();
            init.add(array[i]);
            map.put(i, init);
        }

        // 2. DP 테이블 및 Map 갱신
        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j < i; j++) {
                // 이전 원소가 현재 원소보다 작고,
                // 새로운 부분 수열의 길이가 기존 기록보다 길다면
                if (array[j] < array[i] && dp[i] < dp[j] + 1) {

                    dp[i] = dp[j] + 1; // dp 값 갱신

                    // 원본 리스트를 건드리지 않기 위해 새로운 리스트로 복사 후 추가 => 깊은 복사
                    List<Integer> newList = new ArrayList<>(map.get(j));
                    newList.add(array[i]);
                    map.put(i, newList); // 기존 i의 리스트를 덮어씌운다.
                }
            }
        }

        // 3. 갱신이 끝난 후, 가장 긴 수열의 길이와 그 인덱스 찾기
        int maxLen = 0;
        int bigSizeIndex = 1;
        for (int i = 1; i < N + 1; i++) {
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                bigSizeIndex = i;
            }
        }

        // 4. 결과 출력
        System.out.println(maxLen);
        for (int num : map.get(bigSizeIndex)) {
            System.out.print(num + " ");
        }
    }
}