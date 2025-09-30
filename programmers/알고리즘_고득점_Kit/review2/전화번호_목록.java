package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 전화번호_목록 {

    /** 시간 초과 난 경우 : 모든 전화번호 쌍을 비교하므로 O(N^2) 발생
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Boolean> map = new HashMap<>();

        Arrays.sort(phone_book);
        for (String phone : phone_book) {
            map.put(phone, true);
        }

        for (String phone : map.keySet()) {

            for (String phone2 : map.keySet()) {
                if (!phone.equals(phone2) && phone2.startsWith(phone) ) {
                    answer = false;
                    return answer;
                }
            }
        }

        return answer;
    } **/

    /** 각 번호의 접두어만 확인하고 HashMap.containsKey()는 평균 O(1)이다.
     * 바깥 루프 : 전화번호 개수 N
     * 안쪽 루프 : 전화번호 길이 L (최대 20자)
     */
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Boolean> map = new HashMap<>();

        for (String phone : phone_book) {
            map.put(phone, true);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) return false;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String[] phone_book = new String[size];
        
        sc.nextLine();
        for (int i = 0; i < phone_book.length; i++) {
            phone_book[i] = sc.nextLine();
        }

        System.out.println(solution(phone_book));
    }

}
