package 알고리즘_고득점_Kit.review;

import java.util.*;

public class HIndex {

    public static int solution(int[] citations) {
        int answer = 0;

        Integer[] integerArr = new Integer[citations.length]; // Wrapper 클래스 배열로 변환
        for (int i = 0; i < citations.length; i++) {
            integerArr[i] = citations[i];
        }

        Arrays.sort(integerArr, Collections.reverseOrder()); // 내림차순 정렬


        int sum = 0;
        for (int citation : citations) {
            sum += citation;
        }

        int avg = sum / citations.length;

        int count;
        for (int i = 1; i <= avg; i++) {
            count = 0;

            for (int j = 0; j < citations.length; j++) {
                // 만약, citations[j]의 값이 i랑 같을 경우를 대비해서
                // count가 i랑 같지 않을 때의 조건을 넣었다.
                /**
                 * ex) 6 5 4 3 2
                 * 최댓값이 3이 나와야 한다.
                 * 여기서, i가 3일 때, count != i를 넣지 않으면
                 * count가 결과 값이 4가 되버린다.
                 * 그럼 결국, count == i 조건식을 만족하지 못해 최댓값을 구할 수 없다.
                 */
                if (citations[j] >= i && count != i) {
                    count++;
                }
            }

            if (count == i) {
                answer = Math.max(i, answer);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int citations_size = sc.nextInt();

        int[] citations = new int[citations_size];

        for (int i = 0; i < citations_size; i++) {
            citations[i] = sc.nextInt();
        }

        System.out.println(solution(citations));
    }

}
