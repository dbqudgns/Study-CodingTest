package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 의상 {

    public static int solution(String[][] clothes) {

        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        for (String key : map.keySet()) {
            answer *= map.get(key) + 1; // 1을 더 하는 이유 : 해당 의상 종류를 입지 않는 경우의 수
        }

        return --answer; // 1을 빼는 이유 : 모든 의상 종류를 입지 않는 경우의 수

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
