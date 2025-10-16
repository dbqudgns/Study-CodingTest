package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 가장_큰_수 {

    public static String solution(int[] numbers) {

        String answer = "";
        String[] numbersToString = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numbersToString[i] = String.valueOf(numbers[i]);
        }


        Arrays.sort(numbersToString, (a, b) -> (b+a).compareTo(a+b));

        if (numbersToString[0].equals("0")) return "0";

        for (int i = 0; i < numbersToString.length; i++) {
            answer += numbersToString[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(solution(numbers));
    }

}
