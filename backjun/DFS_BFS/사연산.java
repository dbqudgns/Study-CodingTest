package DFS_BFS;

import java.util.*;
import java.io.*;

public class 사연산 {

    static class Clc {
        long nextS;
        String str;

        public Clc(long nextS, String str) {
            this.nextS = nextS;
            this.str = str;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        long s = Long.parseLong(token.nextToken());
        long t = Long.parseLong(token.nextToken());

        if (s == t) {
            System.out.println(0);
            return;
        }

        Queue<Clc> queue = new ArrayDeque<>();
        queue.add(new Clc(s, ""));


        Set<Long> visited = new HashSet<>();
        visited.add(s);

        while(!queue.isEmpty()) {

            Clc poll = queue.poll();
            long nextS = poll.nextS;

            if (nextS == t) {
                System.out.println(poll.str);
                return;
            }

            long multiplyNum = nextS * nextS;
            if (multiplyNum  <= t && visited.add(multiplyNum)) {
                queue.add(new Clc(multiplyNum, poll.str + "*"));
            }

            long plusNum = nextS + nextS;
            if (plusNum <= t && visited.add(plusNum)) {
                queue.add(new Clc(plusNum, poll.str + "+"));
            }

            long minusNum = nextS - nextS;
            if (minusNum <= t && visited.add(minusNum)) {
                queue.add(new Clc(minusNum, poll.str + "-"));
            }
            
            if (nextS != 0) {
                long divideNum = nextS / nextS;
                if (divideNum <= t && visited.add(divideNum)) {
                    queue.add(new Clc(divideNum, poll.str + "/"));
                }
            }
        }

        System.out.println(-1);

    }

}
