package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class HIndex {

    public static int solution(int[] citations) {
        int answer = 0;

        // H-Index는 보통 맨 뒤쪽에 있으므로 오름차순 정렬 수행
        Arrays.sort(citations);
        int length = citations.length;

        // 0 1 3 5 6
        for (int i = 0; i < length; i++) {
            // length - i : 현재 인덱스 기준으로 논문 개수(h 후보)
            /**
             * 정렬 뒤 각 위치에서 남은 논문 수 length-i와 현재 인용 수를 비교하는 것은
             * 논문 인용 수(citations[i])가 논문의 개수(length-i)보다 크거나 같아지면 그 수가 H-Index가 된다.
             */
            if (citations[i] >= length - i) {
                answer = length - i;
                break;
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
