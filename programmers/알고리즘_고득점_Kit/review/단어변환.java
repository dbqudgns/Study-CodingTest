package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 단어변환 {

    public static int answer = Integer.MAX_VALUE; // DFS 사용
    public static boolean[] visited; // DFS, BFS 사용

    // DFS 풀이 : 모든 경로를 방문하는 로직
    // 즉, 가장 마지막에 찾은 경로를 반환해서 answer의 초기값을 0에서 Integer.MAX_VALUE로 바꾸고 answer의 값을 바꿀 때 Math.min(answer, count)으로 변경
    public static int solution_DFS(String begin, String target, String[] words) {

        visited = new boolean[words.length];
        dfs(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    // BFS 풀이(1)
    /** 위 코드에서 begin 단어에서 변환할 수 있는 첫 단어를 하나만 찾으면 break;를 통해 반복을 멈춘다.
     만약 최단 경로가 나중에 나오는 다른 단어로부터 시작된다면 ? 그러면, 현재 코드는 그 경로를 아예 탐색하지 못한다.
     따라서 begin에서 한 번에 변환될 수 있는 모든 단어를 찾아서 큐에 넣어보는 로직을 작성해보았다. => solution_bfs_2
     **/
    public static int solution_BFS(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        Queue<Integer> queue = new ArrayDeque<>();

        // 첫번째로 변환할 문자열의 인덱스를 큐에 삽입
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            if (convert(begin, str)) {
                visited[i] = true;
                queue.add(i);
                break;
            }
        }

        int cnt = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = words[queue.remove()];

                if (cur.equals(target)) {
                    return cnt;
                }

                for (int i = 0; i < words.length; i++) {
                    if (visited[i]) continue;

                    String str = words[i];
                    if (convert(cur, str)) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
            cnt++;
        }
        return 0;
    }

    // Node는 현재 단어(word)와 변환 횟수(count)를 저장하는 클래스
    static class Node {
        String word;
        int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static int solution_BFS_2(String begin, String target, String[] words) {

        Queue<Node> queue = new ArrayDeque<>();
        visited = new boolean[words.length];

        // 1. target이 words 안에 없으면 변환 불가이므로 0을 반환
        boolean isExist = false;
        for (String word : words) {
            if (word.equals(target)) {
                isExist = true;
                break;
            }
        }

        if (!isExist) return 0;

        // 2. BFS 탐색 시작
        queue.add(new Node(begin, 0));

        while(!queue.isEmpty()) {
            Node cur = queue.remove();

            if (cur.word.equals(target)) {
                return cur.count;
            }

            for (int i = 0; i < words.length; i++) {
                // 아직 방문하지 않았고 한 글만자만 차이 나는 경우
                if (!visited[i] && convert(cur.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i], cur.count+1));
                }
            }
        }

        return 0;
    }

        public static void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (convert(begin, words[i]) && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }

    public static boolean convert(String from, String to) {
        int len = from.length();
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (from.charAt(i) == to.charAt(i)) {
                count++;
            }
        }

        return count+1 == len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String begin = sc.nextLine();
        String target = sc.nextLine();

        int size = sc.nextInt();
        sc.nextLine();
        String[] words = new String[size];
        for (int i = 0; i < size; i++) {
            words[i] = sc.nextLine();
        }

        System.out.println(solution_DFS(begin, target, words));
        System.out.println(solution_BFS(begin, target, words));
        System.out.println(solution_BFS_2(begin, target, words));

    }
}
