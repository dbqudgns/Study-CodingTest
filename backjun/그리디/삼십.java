package 그리디;

import java.util.*;
import java.io.*;

public class 삼십 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] charArray = input.toCharArray();

        Arrays.sort(charArray);

        // String value = ""; => 시간 초과 발생으로 StringBuilder 쓰자
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            int num = charArray[i] - '0';
            // value += num;
            sb.append(num);
            sum += num;
        }

        if (sum % 3 == 0 && charArray[0] == '0') {
            // System.out.println(value);
            System.out.println(sb.toString());
            return;
        }

        System.out.println(-1);
    }

}
