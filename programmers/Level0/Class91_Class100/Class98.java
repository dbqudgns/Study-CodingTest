// 겹치는 선분의 길이
package Level0.Class91_Class100;

import java.util.Scanner;

public class Class98 {

    public static int solution(int[][] lines) {

        int answer = 0;

        // 선분의 각 좌표 a, b는 -100 이상 100 이하의 값을 가질 수 있다.
        // 그리고 총 201개(0 ~ 200)의 값를 가질 수 있다.
        // 1. line_arr : 해당 점을 지나가는 선분의 개수를 카운트하기 위해 선언
        int[] line_arr = new int[201];

        // 2. lines 순회 : 한 line 순회
        for (int[] line : lines) {
            int a = line[0];
            int b = line[1];

            // 음수를 없애기 위해 100씩 추가 0 => 100 -100 => 0
            a = a + 100;
            b = b + 100;

            // 3. 배열의 표식을 위한 a ~ b-1 범위까지 순회
            // 마지막을 포함하지 않는 이유는 경계점에 대한 중복 체킹을 방지하기 위해서
            for (int i = a; i < b; i++) {

                // 경계점을 이미 지나갔는데 또 지나갈 경우 개수 증가
                if (line_arr[i] == 1) answer += 1;

                // 경계점을 처음 지나간 경우
                line_arr[i] += 1;
            }

        }

        return answer;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] lines = new int[3][2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                lines[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(lines));

    }
}
