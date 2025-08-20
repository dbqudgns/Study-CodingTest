package 알고리즘_고득점_Kit.탐욕법;

import java.util.*;

public class 조이스틱 {

    public static int solution(String name) {
        int answer = 0;
        int len = name.length(); // 이름의 길이

        int index; // 다음 A가 아닌 문자의 위치
        int move = len - 1; // 커서 이동의 최소값 (기본 값: 오른쪽으로 끝까지 이동하는 경우)

        // 0번 인덱스부터 끝까지 순회
        for (int i = 0; i < len; i++) {

            // 현재 알파벳을 'A'에서 원하는 문자로 바꾸기 위한 최소 조작 횟수 계산
            // 위로 이동할지, 아래로 이동할지 더 적은 횟수를 선택
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 다음 문자 위치부터 확인 시작
            index = i + 1;

            // 연속된 'A' 구간을 건너뛰기 위해 반복
            // A가 아니면 멈추고, index는 다음 A가 아닌 문자의 위치를 가리킨다.
            while (index < len && name.charAt(index) == 'A') {
                index++;
            }

            /**
             * 커서 이동 최소화 전략 (1)
             * i : 인덱스 0부터 오른쪽으로 이동한 거리
             * len - index : 연속된 A를 피하고 뒤쪽으로 돌아가서 처리해야 할 문자 수
             * i * 2는 인덱스 0부터 오른쪽으로 갔다가 왼쪽으로 되돌아오기 위한 거리
             * 전체적으로 오른쪽을 처리하고 왼쪽으로 돌아가서 A 뒤쪽을 처리한다.
             *
             * 전략 1이 유리한 경우 : 초반에 바꿔야 할 문자가 많고, 뒤쪽 A가 많은 경우
             * J A N A A A A N
             */
            move = Math.min(move, i * 2 + len - index);

            /**
             * 커서 이동 최소화 전략 (2)
             * (len - index) * 2 : 뒤쪽인 왼쪽으로 가서 오른쪽으로 돌아오기
             * + i : 오른쪽 문자 처리
             *
             * 전략 2가 유리한 경우 : 뒤쪽에 바꿔야 할 문자가 많고, 앞쪽 A가 많은 경우
             * A A A J A N
             */
            move = Math.min(move, (len - index) * 2 + i);
        }

        return answer + move;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        System.out.println(solution(name));
    }

}
