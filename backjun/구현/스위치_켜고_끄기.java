package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치_켜고_끄기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchSize = Integer.parseInt(br.readLine());

        int[] switches = new int[switchSize + 1];
        StringTokenizer token = new StringTokenizer(br.readLine());

        for (int i = 1; i < switchSize + 1; i++) {
            switches[i] = Integer.parseInt(token.nextToken());
        }

        int stateSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < stateSize; i++) {
            token = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(token.nextToken());
            int center = Integer.parseInt(token.nextToken());

            // 남학생 처리
            if (gender == 1) {

                for (int index = center; index < switchSize + 1; index++) {
                    if (index % center == 0) {
                        change(switches, index);
                    }
                }

            }
            // 여학생 처리
            else {

                int value = 0; // 대칭 거리
                boolean cnt = true;
                while(true) {

                    int leftIndex = center - (value + 1);
                    int rightIndex = center + (value + 1);

                    if (leftIndex <= 0 || rightIndex >= switchSize + 1) break;

                    if (switches[leftIndex] != switches[rightIndex]) break;

                    value++; // 대칭이면 거리 증가
                }

                // 확인된 대칭 구간 모두 상태 변경
                for (int j = center - value; j <= center + value; j++) {
                    change(switches, j);
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num = 1; num < switchSize + 1; num++) {
            sb.append(switches[num]).append(" ");

            if (num % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void change(int[] switches, int index) {
        if (switches[index] == 0) {
            switches[index] = 1;
        }
        else {
            switches[index] = 0;
        }
    }
}