package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 모음사전 {

    static char[] alphabet = new char[]{'A', 'E', 'I', 'O', 'U'};

    public static int solution(String word) {

        List<String> lists = new ArrayList<>();

        dfs("", 0, lists);

        return lists.indexOf(word) + 1;

    }

    public static void dfs(String str, int length, List<String> lists) {

        if (length > 5) return;

        if (!str.isEmpty()) lists.add(str);

        for (char c : alphabet) {
            dfs(str + c, length + 1, lists);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        System.out.println(solution(word));
    }

}
