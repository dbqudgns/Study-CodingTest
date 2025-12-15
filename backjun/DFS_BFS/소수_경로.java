package DFS_BFS;

import java.io.*;
import java.util.*;

public class 소수_경로 {

    static boolean[] isPrime;
    static boolean[] visited;

    // 에라토스테네스의 체
    static void isPrimeFunction() {
        isPrime = new boolean[10001]; // 10000번째의 수 까지 받기 위해 10001까지 할당

        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true; // boolean 배열의 default 값은 false이므로 true로 바꿔주기
        }

        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아니므로 false로 변환

        // 2부터 10000의 제곱근 100까지의 모든 수를 확인한다.
        for (int i = 2; i <= Math.sqrt(10000); i++) {
            if (isPrime[i]) { // 해당 수가 소수라면, 해당 수를 제외한 배수들을 모두 false 처리하기
                // 그 이하의 수(i*i보다 작은 i의 배수들)는 모두 검사했으므로 i*i부터 시작
                for (int j = i * i; j <= 10000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static int bfs(int start, int end) {
        int result = Integer.MAX_VALUE;
        visited = new boolean[10001];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{start, 0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int number = poll[0];
            int count = poll[1];

            if (number == end) {
                result = Math.min(result, count);
            }

            // 1000의 자리
            char[] charArray1000 = String.valueOf(number).toCharArray();
            for (int i = 1; i <= 9; i++) {
                charArray1000[0] = (char) ('0' + i);
                int nextNumber = Integer.parseInt(new String(charArray1000));

                // nextNumber가 소수이고 방문하지 않았다면
                if (isPrime[nextNumber] && !visited[nextNumber]) {
                    visited[nextNumber] = true;
                    queue.add(new int[]{nextNumber, count+1});
                }
            }

            // 100의 자리
            char[] charArray100 = String.valueOf(number).toCharArray();
            for (int i = 0; i <= 9; i++) {
                charArray100[1] = (char) ('0' + i);
                int nextNumber = Integer.parseInt(new String(charArray100));

                // nextNumber가 소수이고 방문하지 않았다면
                if (isPrime[nextNumber] && !visited[nextNumber]) {
                    visited[nextNumber] = true;
                    queue.add(new int[]{nextNumber, count+1});
                }
            }

            // 10의 자리
            char[] charArray10 = String.valueOf(number).toCharArray();
            for (int i = 0; i <= 9; i++) {
                charArray10[2] = (char) ('0' + i);
                int nextNumber = Integer.parseInt(new String(charArray10));

                // nextNumber가 소수이고 방문하지 않았다면
                if (isPrime[nextNumber] && !visited[nextNumber]) {
                    visited[nextNumber] = true;
                    queue.add(new int[]{nextNumber, count+1});
                }
            }

            // 1의 자리
            char[] charArray1 = String.valueOf(number).toCharArray();
            for (int i = 0; i <= 9; i++) {
                charArray1[3] = (char) ('0' + i);
                int nextNumber = Integer.parseInt(new String(charArray1));

                // nextNumber가 소수이고 방문하지 않았다면
                if (isPrime[nextNumber] && !visited[nextNumber]) {
                    visited[nextNumber] = true;
                    queue.add(new int[]{nextNumber, count+1});
                }
            }

        }


        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;

        isPrimeFunction();

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            int result = bfs(start, end);

            if (result >= 0) sb.append(result).append("\n");
            else sb.append("Impossible\n");
        }

        System.out.println(sb.toString());


    }
}
