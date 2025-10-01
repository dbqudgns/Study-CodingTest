package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 의상 {

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        // +1 : 아무 것도 입지 않은 경우를 고려
        // 바지를 통해 나올 수 있는 경우의 수 : 바지 의상이 총 2개 + 안입는 경우(1) = 3개
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 1) + 1);
        }

        for (int value : map.values()) {
            answer *= value;
        }

        // 최소 의상 1개는 입는다 하였으니 아예 의상들을 입지 않는 경우는 빼기 (-1)
        return answer - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String[][] clothes = new String[size][2];

        sc.nextLine();
        for (int i = 0; i < clothes.length; i++) {
            for (int j = 0; j < 2; j++) {
                clothes[i][j] = sc.nextLine();
            }
        }

        System.out.println(solution(clothes));

    }

}
