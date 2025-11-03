package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 단어_변환 {

    static int answer = Integer.MAX_VALUE;

    public static int solution(String begin, String target, String[] words) {

        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (!target.equals(words[i])) {
                count++;
            }
        }

        if (count == words.length) {
            answer = 0;
            return answer;
        }

        boolean[] visited = new boolean[words.length];

        dfs(begin, target, words, visited, 0);

        return answer;
    }

    public static void dfs(String begin, String target, String[] words, boolean[] visited, int count) {
        if (begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {

            boolean nextStep = false;
            int index = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    index++;
                }
            }

            if (index == words[i].length() - 1) nextStep = true;

            if (!visited[i] && nextStep) {
                visited[i] = true;
                dfs(words[i], target, words, visited, count+1);
                visited[i] = false; // 백트래킹
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String begin = sc.nextLine();
        String target = sc.nextLine();

        int size = sc.nextInt();
        String[] words = new String[size];

        sc.nextLine();

        for (int i = 0; i < size; i++) {
            words[i] = sc.nextLine();
        }

        System.out.println(solution(begin, target, words));
    }

}
