// 정렬

package 알고리즘_고득점_Kit.정렬;

import java.util.*;

public class HIndex {

    public static int solution(int[] citations) {

        int answer = 0;

        Arrays.sort(citations);

        int length = citations.length;

        for (int i = 0; i < length; i++) {
            // citations[i] : 논문의 인용 횟수
            // length - i : 현재 인덱스 기준으로 남은 논문 개수
            if (citations[i] >= length - i) { // 논문 i 번째의 인용 횟수가 남은 논문 개수 이상일 경우 HIndex 만족
                answer = length - i; // 즉, 인용 횟수가 적어도 length-i 이상인 논문이 length-i편 존재한다.
                return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] citations = new int[size];

        for (int i = 0; i < size; i++) {
            citations[i] = sc.nextInt();
        }

        System.out.println(solution(citations));
    }


}
