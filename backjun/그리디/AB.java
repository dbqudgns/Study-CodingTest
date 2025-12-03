package 그리디;

import java.util.*;
import java.io.*;

public class AB {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        /** 1) A의 개수 a를 선택
         * a개의 A, b개의 B로 만들 수 있는 최대 쌍 = a * b
         * a * b >= K를 만족하는 가장 작은 a를 찾는다.
         * 가장 작은 a보다 더 큰 a도 가능하지만,
         * 문제에서 조건을 만족하면 아무거나 출력하라 했으므로
         * 가장 작은 a를 기준으로 잡았다.
         */
        int a = -1;
        for (int i = 0; i <= N; i++) {
            int b = N - i; // B의 개수
            if (i * b >= K) {
                a = i; // 조건을 충족하는 A의 개수
                break;
            }
        }

        // 만족하는 a가 없다면 만들 수 없는 경우
        if (a == -1) {
            System.out.println(-1);
            return;
        }

        int b = N - a; // B의 개수
        int maxPair = a * b; // 최대 (A, B) 쌍
        int drop = maxPair - K; // 줄여야 하는 쌍 개수

        /** 2) 문자열 기본은 모두 B로 채워두고
         * 필요한 자리만 'A'로 바꾸는 방식
         */
        char[] answer = new char[N];
        Arrays.fill(answer, 'B');

        /** 3) A들을 오른쪽 끝 A부터 순서대로 배치
         * 오른쪽 A일수록 충돌이 없고 조절하기 편하다.
         * shift = min(drop, b)
         *  - A를 shift칸 오른쪽으로 옮기면 그만큼 (A, B) 쌍이 줄어든다.
         */
        for (int i = a-1; i >= 0; i--) {
               int shift = Math.min(drop, b); // A가 이동할 칸 수
               int pos = i + shift; // 이동 후 A의 위치
               answer[pos] = 'A';
               drop -= shift; // 줄인 쌍만큼 drop 감소
        }

        System.out.println(new String(answer));
    }

}