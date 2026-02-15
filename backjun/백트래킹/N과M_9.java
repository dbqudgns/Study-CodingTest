    package 백트래킹;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class N과M_9 {

        static int N, M;
        static int[] array;
        static int[] answer;
        static boolean[] visited;

        static StringBuilder sb;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer token = new StringTokenizer(br.readLine());

            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            array = new int[N];
            answer = new int[M];
            visited = new boolean[N];

            token = new StringTokenizer(br.readLine());
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(token.nextToken());
            }

            Arrays.sort(array);

            sb = new StringBuilder();
            solution(0);

            System.out.print(sb);
        }

        public static void solution(int depth) {

            // 기저 조건
            if (depth == M) {
                for (int num : answer) {
                    sb.append(num).append(" ");
                }
                sb.append("\n");
                return;
            }

            // 수행
            int before = 0; // 현재 depth에서 이전에 선택한 값을 기억할 변수
            for (int i = 0; i < N; i++) {

                if (visited[i] || before == array[i]) continue;

                visited[i] = true;
                answer[depth] = array[i];
                before = array[i];

                solution(depth + 1);

                visited[i] = false;
            }
        }
    }