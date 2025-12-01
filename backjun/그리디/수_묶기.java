package 그리디;

import java.util.*;
import java.io.*;

public class 수_묶기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> minusZero = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();
        int one = 0;

        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(br.readLine());

            if (num <= 0) minusZero.add(num);
            else if (num == 1) one++; // 1은 따로 처리
            else plus.add(num);
        }

        minusZero.sort(Comparator.naturalOrder()); // 오름차순
        plus.sort(Comparator.reverseOrder()); // 내림차순

        int sum = 0;
        sum += one; // 1은 무조건 더하기

        // 양수 처리 (2이상)
        for (int i = 0; i < plus.size(); i++) { // ex. 0:2, 1:3, 2:4
            if (i+1 < plus.size()) {
                sum += plus.get(i) * plus.get(i+1);
                i++;
            }
            else sum += plus.get(i);
        }

        // 음수 + 0 처리
        for (int i = 0; i < minusZero.size(); i++) {
            if (i + 1 < minusZero.size()) {
                sum += minusZero.get(i) * minusZero.get(i + 1);
                i++;
            }
            else {
                // 마지막 하나가 음수인데 짝이 없다면
                if (minusZero.get(i) != 0) sum += minusZero.get(i);
            }
        }

        System.out.println(sum);
    }

}
