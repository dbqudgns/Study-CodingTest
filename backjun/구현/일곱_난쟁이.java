package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱_난쟁이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] small = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            small[i] = Integer.parseInt(br.readLine());
            sum += small[i];
        }

        boolean found = false;
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - small[i] - small[j] == 100) {
                    small[i] = 0;
                    small[j] = 0;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        Arrays.sort(small);

        for (int i = 2; i < 9; i++) {
            System.out.println(small[i]);
        }
    }
}