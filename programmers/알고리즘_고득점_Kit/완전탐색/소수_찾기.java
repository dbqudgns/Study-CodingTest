// 완전 탐색
package 알고리즘_고득점_Kit.완전탐색;

import java.util.*;

public class 소수_찾기 {

    // 011과 같이 앞 자리가 0으로 시작할 경우 11로 저장됨
    // HashSet은 중복된 숫자를 저장하지 않는다.
    static Set<Integer> numberSet = new HashSet<>();

    // 소수 판별
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // 숫자 조합 만들기 -> DFS 알고리즘 사용
    public static void dfs(String numbers, String current, boolean[] visited) {
        if (!current.equals("")) {
            numberSet.add(Integer.parseInt(current));
        }

        for(int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, current+numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

    public static int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, "", visited);

        int count = 0;
        for (int num : numberSet) {
            if (isPrime(num)) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        System.out.println(solution(numbers));
    }
}
