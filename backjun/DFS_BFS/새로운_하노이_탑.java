package DFS_BFS;

import java.util.*;
import java.io.*;

public class 새로운_하노이_탑 {

    static class State {
        String[] rods;
        int dist;

        State(String[] rods, int dist) {
            this.rods = rods;
            this.dist = dist;
        }
    }

    // 상태를 하나의 문자열로 변환 (방문 체크용)
    static String encode(String[] rods) {
        return rods[0] + "|" + rods[1] + "|" + rods[2];
    }

    // 목표 상태인지 확인
    static boolean isGoal(String[] rods) {
        for (int i = 0; i < 3; i++) {
            for (char c : rods[i].toCharArray()) {
                if (c != 'A' + i) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 각 막대의 원판 상태
        String[] start = new String[3];

        // 각 막대의 원판 초기 상태 입력 받은 후 저장
        for (int i = 0; i < 3; i++) {
            String line = br.readLine();

            // 0이면 빈 막대
            if (line.equals("0")) {
                start[i] ="";
            }

            // 비지 않은 막대의 현재 원판 상태 저장
            else {
                start[i] = line.split(" ")[1];
            }
        }

        Queue<State> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.add(new State(start, 0));
        visited.add(encode(start));

        while(!queue.isEmpty()) {
            State cur = queue.poll();

            if (isGoal(cur.rods)) {
                System.out.println(cur.dist);
                return;
            }

            for (int i = 0; i < 3; i++) {
                if (cur.rods[i].isEmpty()) continue;

                // 현재 막대의 맨 위 원판 가져오기
                char top = cur.rods[i].charAt(cur.rods[i].length() - 1);

                // i번 막대의 맨 위 원판을(top) j번 막대로 옮긴 새로운 상태를 만든다.
                for (int j = 0; j < 3; j++) {
                    if (i==j) continue; // 자기 자신은 처리 X

                    String[] next = cur.rods.clone();
                    next[i] = next[i].substring(0, next[i].length() - 1);
                    next[j] = next[j] + top;

                    String key = encode(next);
                    if (!visited.contains(key)) {
                        visited.add(key);
                        queue.add(new State(next, cur.dist+1));
                    }
                }
            }
        }
    }
}
