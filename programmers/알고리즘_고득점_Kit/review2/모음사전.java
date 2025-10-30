package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 모음사전 {
    
    static int count = 0;
    static int answer = 0;
    static boolean found = false;
    
    public static int solution(String word) {
        String[] ap = {"A", "E", "I", "O", "U"};
        
        dfs(word, ap, "");
        
        return answer;
    }
    
    public static void dfs(String word, String[] ap, String now) {

        if (found) return; // 이미 찾았으면 더 이상 탐색하지 않음

        if (word.equals(now)) {
            answer = count;
            found = true;
            return;
        }

        if (now.length() == 5) return;
        
        for (int i = 0; i < 5; i++) {
            count++;
            dfs(word, ap, now+ap[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        System.out.println(solution(word));
    }
    
}
