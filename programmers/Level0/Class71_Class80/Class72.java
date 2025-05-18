// 잘라서 배열로 저장하기
package Level0.Class71_Class80;

import java.util.Arrays;
import java.util.Scanner;

public class Class72 {

    public static String[] solution(String my_str, int n) {

        // 1. 문제 풀이에 필요한 변수 선언
        String[] answer = {};
        if (my_str.length() % n == 0) answer = new String[my_str.length() / n];
        else answer = new String[my_str.length() / n + 1];

        int size = my_str.length(); // my_str 전체 길이 조건문 진행에 필요
        int index = 0; // my_str에 있는 한 개의 문자/숫자를 가져오기 위한 인덱스
        int answerIndex = 0; // answer 배열 전용 인덱스

        // 2. 현재 size가 n 보다 크거나 같을 경우 substring을 통해 my_str n씩 분해
        while (size >= n) {
            answer[answerIndex] = my_str.substring(index, index + n);
            index += n;
            size -= n;
            answerIndex++;
        }

        // 3. my_str의 나머지 문자들을 삽입
        if (size > 0 && size < n) answer[answerIndex] = my_str.substring(index);


        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String my_str = sc.nextLine();
        int n = sc.nextInt();

        System.out.println(Arrays.toString(solution(my_str, n)));

    }

}
