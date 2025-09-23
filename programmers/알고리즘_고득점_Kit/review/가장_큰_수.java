package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 가장_큰_수 {

    /** DFS 풀이 시 number가 int 범위를 범어나서 NumberFormatException 발생한다.
    static Set<Integer> numList;
    static boolean[] visited;

    public static String solution(int[] numbers) {
        String answer;

        numList = new HashSet<>();
        visited = new boolean[numbers.length];

        dfs(numbers, null, 0);

        List<Integer> list = new ArrayList<>(numList);

        list.sort(Comparator.reverseOrder());

        answer = String.valueOf(list.getFirst());

        return answer;
    }

    public static void dfs(int[] numbers, String number, int index) {

        if (index == numbers.length) numList.add(Integer.valueOf(number));

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;

                if (number == null) dfs(numbers, String.valueOf(numbers[i]), index + 1);
                else dfs(numbers, number + numbers[i], index + 1);

                visited[i] = false;
            }
        }

    }
     */

    public static String solution(int[] numbers) {
        String answer = "";

        String[] numbersToString = new String[numbers.length];
        for (int i = 0; i < numbersToString.length; i++) {
            numbersToString[i] = String.valueOf(numbers[i]);
        }

        // 문자열을 더한 값이 큰 순서대로 내림차순 정렬한다.
        /**
         * 예시 2) a = "30", b = "3"
         * a+b = "303"
         * b+a = "330"
         * "330" > "303" → b 가 a 앞에 와야 함.
         * 즉, sort 함수는 compareTo의 반환이 양수여서 b와 a의 위치를 바꾼다.
         * 음수 → a가 b보다 앞에 옴
         * 0 → 순서 유지
         * 양수 → a가 b보다 뒤에 옴
         */
        Arrays.sort(numbersToString, (a, b) -> (b + a).compareTo(a + b));

        if (numbersToString[0].equals("0")) return "0";

        for (String str : numbersToString) {
            answer += str;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numbers_size = sc.nextInt();
        int[] numbers = new int[numbers_size];

        for (int i = 0; i < numbers_size; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(solution(numbers));
    }

}
