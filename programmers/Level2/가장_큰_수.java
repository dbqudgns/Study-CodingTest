// 정렬
package Level2;

import java.util.*;

public class 가장_큰_수 {

    public static String solution(int[] numbers) {

        String answer = "";

        // 1. 정수형의 정수들을 문자열로 타입 캐스팅한다.
        String[] numbersToString = new String[numbers.length];
        for (int i = 0; i < numbersToString.length; i++) {
            numbersToString[i] = String.valueOf(numbers[i]);
        }

        // 2. 문자열을 더한 값이 큰 순서대로 내림차순 정렬한다.
        Arrays.sort(numbersToString, (a, b) -> (b + a).compareTo(a+b));

        // 3. 문자열 배열 맨 앞 값이 0일 경우 0을 반환
        if (numbersToString[0].equals("0")) return "0";

        // 4. 반복문을 통해 정렬된 문자열을 연결한다.
        for (String str : numbersToString) {
            answer += str;
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] numbers = new int[size];

        for(int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(solution(numbers));

    }


}
