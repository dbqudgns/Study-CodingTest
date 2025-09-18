package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 소수찾기 {

    static Set<Integer> result = new HashSet<>();

    public static int solution(String numbers) {

        boolean[] visited = new boolean[numbers.length()];
        String[] numSplit = numbers.split("");

        dfs(numSplit, visited, "");

        return result.size();
    }

    public static void dfs(String[] numSplit, boolean[] visited, String number) {

        if (!number.equals("")) {
            int num = Integer.parseInt(number);

            if (isPrime(num)) {
                result.add(num); // 소수일 때 Set에 추가
            }
        }

        for (int i = 0; i < numSplit.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numSplit, visited, number + numSplit[i]);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();

        System.out.println(solution(numbers));
    }
}
