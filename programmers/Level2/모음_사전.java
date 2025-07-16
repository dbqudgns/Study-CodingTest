package Level2;

import java.util.*;

public class 모음_사전 {
    static List<String> dictionary = new ArrayList<>();
    static char[] vowel = new char[]{'A', 'E', 'I', 'O', 'U'};

    // 모음 사전을 만들어보자
    public static void dfs(String str, int length) {

        // length 길이가 5이상일 경우 return
        if (length > 5) return;

        // 인수 str이 비어있지 않으면 사전에 저장
        if(!str.isEmpty()) {
            dictionary.add(str);
        }

        // 재귀 호출을 통해 사전에 값을 저장
        for (int i = 0; i < vowel.length; i++) {
            dfs(str + vowel[i], length + 1);
        }
    }

    public static int solution(String word) {
        int length = 0;

        dfs("", length);

        // 사전 정렬
        Collections.sort(dictionary);

        return dictionary.indexOf(word) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        System.out.println(solution(word));
    }
}
