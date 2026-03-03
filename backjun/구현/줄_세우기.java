package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 줄_세우기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] array = new int[size+1];
        int[] answer = new int[size+1];

        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 1; i < size + 1; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 1; i < size + 1; i++) {
            int curIndex = i - array[i];
            for (int j = i; j > curIndex; j--) answer[j] = answer[j - 1];
            answer[curIndex] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < size + 1; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.print(sb);
    }

}
