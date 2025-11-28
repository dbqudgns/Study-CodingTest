package 그리디;

import java.util.*;
import java.io.*;

public class 잃어버린_괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] split = str.split("-");

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < split.length; i++) {

            int temp = 0;
            if (split[i].contains("+")) {
                // +는 메타문자(특별한 의미를 담고 있는 문자)라서
                // 그 자체로 이용하기 위해서는 이스케이프(\) 처리를 해야한다.
                // 하지만 \도 단독으로 출력할 수 없어 이스케이프(\) 처리를 해야한다.
                String[] twoSplit = split[i].split("\\+");

                for (int j = 0; j < twoSplit.length; j++) {
                    temp += Integer.parseInt(twoSplit[j]);
                }
            }
            else temp = Integer.parseInt(split[i]);

            if (answer == Integer.MAX_VALUE) {
                answer = 0;
                answer += temp;
            }
            else {
                answer -= temp;
            }

        }

        System.out.println(answer);
    }

}
