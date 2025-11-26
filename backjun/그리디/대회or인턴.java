package 그리디;

import java.util.*;
import java.io.*;

public class 대회or인턴 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        int count = 0;
        while(N >= 2 && M >= 1 && N+M >= 3+K) {
            count++;
            N -= 2;
            M -= 1;
        }

        System.out.println(count);
    }

}
