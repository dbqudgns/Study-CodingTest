package Level3;

import java.util.*;

public class 단어변환 {

    static boolean[] visited;
    static int answer;

    public static int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;

        boolean beginStart = false;
        for (String word : words) {
            if (word.equals(target)) {
                beginStart = true;
                break;
            }
        }

        if (!beginStart) return 0;

        visited = new boolean[words.length];
        dfs(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;

    }

    public static void dfs(String current, String target, String[] words, int depth) {

        if (current.equals(target)) {
           answer = Math.min(answer, depth);
           return;
        }

        for (int i = 0; i < words.length; i++) {

            if (!visited[i]) {
                int count = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    if (current.charAt(j) == words[i].charAt(j)) {
                        count++;
                    }
                }

                if (count == current.length() - 1) {
                    visited[i] = true;
                    dfs(words[i], target, words, depth + 1);
                    visited[i] = false; // 백트래킹
                }
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

        for (int i = 0; i < words.length; i++) {
            words[i] = sc.nextLine();
        }

        System.out.println(solution(begin, target, words));

    }

}
