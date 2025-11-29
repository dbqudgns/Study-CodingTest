package 그리디;

import java.io.*;
import java.util.*;

public class 병든_나이트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        if (N == 2) {
            System.out.println(Math.min(4, (M+1) / 2));
            return;
        }

        if (N >= 3) {
            if (M < 7) {
                System.out.println(Math.min(4, M));
            }
            else {
                System.out.println(M - 2);
            }
        }
    }


}
