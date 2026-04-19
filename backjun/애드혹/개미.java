package 애드혹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(token.nextToken());
        int h = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(token.nextToken());
        int q = Integer.parseInt(token.nextToken());

        int t = Integer.parseInt(br.readLine());

        int bumpWallX = (p + t) / w;
        int currentX = 0;
        if (bumpWallX % 2 == 0) {
            currentX = (p + t) % w;
        }
        else currentX = w - ((p + t) % w);

        int bumpWallY = (q + t) / h;
        int currentY = 0;
        if (bumpWallY % 2 == 0) {
            currentY = (q + t) % h;
        }
        else currentY = h - ((q + t) % h);

        System.out.print(currentX + " " + currentY);
    }

}
