package 알고리즘_고득점_Kit.review;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 전화번호_목록 {

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Boolean> map = new HashMap<>();

        for (String number : phone_book) {
            map.put(number, true);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String[] phone_book = new String[size];

        for (int i = 0; i < size; i++) {
            phone_book[i] = sc.next();
        }

        System.out.println(solution(phone_book));
    }

}
