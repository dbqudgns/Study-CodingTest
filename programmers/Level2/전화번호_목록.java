// 해시
package Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 전화번호_목록 {

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        // 1. phone_book에 있는 값들을 저장하는 HashMap 선언
        Map<String, Boolean> map = new HashMap<>();

        // 2. 모든 전화번호를 HashMap에 넣는다.
        for (String str : phone_book) {
            map.put(str, true);
        }

        // 3. 이중 for()문을 통해 phone_book의 한 값을 기준으로 substring()을 통해 비교 반복 수행
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                // 같은 전화번호가 중복해서 들어가 있지 않으므로 substring을 활용
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }

        return answer;
    }

    /** 단순 배열을 통해 시간복잡도 단축 */
//    class Solution {
//        public boolean solution(String[] phoneBook) {
//            Arrays.sort(phoneBook);
//            boolean result = true;
//            for (int i=0; i<phoneBook.length-1; i++) {
//                if (phoneBook[i+1].startsWith(phoneBook[i])) {
//                    result = false;
//                    break;
//                }
//            }
//            return result;
//        }
//    }

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
