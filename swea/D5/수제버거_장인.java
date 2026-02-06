package D5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수제버거_장인 {

    static int N, M;
    static int answer;
    static List<int[]> badPairs;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        int test_case = Integer.parseInt(br.readLine());

        for (int index = 1; index <= test_case; index++) {

            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());

            badPairs = new ArrayList<>();

            answer = 0;

            for (int i = 0; i < M; i++) {
                token = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());

                badPairs.add(new int[] {a, b});
            }

            dfs(1, new ArrayList<>());

            System.out.println("#" + index + " " + answer);
        }
    }

    public static void dfs(int start, List<Integer> lists) {

        answer++;

        for (int i = start; i <= N; i++) {

            if (check(lists, i)) {
                lists.add(i);
                dfs(i + 1, lists);
                lists.remove(lists.size() - 1);
            }
        }
    }

    // 현재 구성된 재료들(lists)에 새로운 재료가 들어가도 되는지
    public static boolean check(List<Integer> lists, int current) {
        for (int[] pair : badPairs) {
            if (pair[0] == current && lists.contains(pair[1])) return false;
            if (pair[1] == current && lists.contains(pair[0])) return false;
        }
        return true;
    }
}