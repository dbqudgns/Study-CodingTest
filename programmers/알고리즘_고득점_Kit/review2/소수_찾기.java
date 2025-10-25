package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 소수_찾기 {

    static Set<Integer> numberSet = new HashSet<>();

    public static int solution(String numbers) {
        String[] split = numbers.split("");
        boolean[] visited = new boolean[split.length];

        dfs(split, visited, "");

        int answer = 0;
        for (int num : numberSet) {
            if (isPrime(num)) answer++;
        }

        return answer;
    }

    public static void dfs(String[] split, boolean[] visited, String current) {
        if (!current.equals("")) {
            numberSet.add(Integer.parseInt(current));
        }

        for (int i = 0; i < split.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(split, visited, current+split[i]); // 1 -> 17 -> 7 -> 71
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int num) {
        int sqrt = (int)Math.sqrt(num);
        if (num <= 1) return false;
        for (int i = 2; i <= sqrt; i++) {
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