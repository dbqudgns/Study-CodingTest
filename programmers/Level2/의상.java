// 해시
package Level2;

import java.util.*;

public class 의상 {

    public static int solution(String[][] clothes) {

        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        // 1. HashMap을 이용해 의상 종류별로 개수 증가
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        // 2. 각 의상 종류별 개수에 +1을 한 후 answer와 덧셈 수행
        // +1 : 해당 의상 종류를 입지 않는 경우의 수
        for (String str : map.keySet()) {
            answer += map.get(str) + 1;
        }

        // answer에는 모든 의상을 입지 않는 경우의 수도 포함되어 있다.
        return --answer; // 모든 의상을 입지 않는 경우의 수(1)를 빼줘야 한다.
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        String[][] clothes = new String[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                clothes[i][j]  = sc.next();
            }
        }

        System.out.println(solution(clothes));
    }
}
