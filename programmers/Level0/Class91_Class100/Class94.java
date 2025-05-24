// 다음에 올 숫자
package Level0.Class91_Class100;

import java.util.Scanner;

public class Class94 {

    public static int solution(int[] common) {
        // 등차수열 판별 : common[n+1] = common[n] + d => d = common[n+1] - common[n]
        // 등비수열 판별 : common[n+1] = common[n] * r => r = common[n+1] / common[n]

        int answer = 0;

        // 1. 문제 제한 사항 중 "2 < common의 길이 < 1000"을 고려하여 인덱스 설정으로 등차수열 판별
        if (common[1] - common[0] == common[2] - common[1]) {
            int d = common[1] - common[0];
            answer = common[common.length - 1] + d;
        }
        // 2. 문제 제한 사항 중 "2 < common의 길이 < 1000"을 고려하여 인덱스 설정으로 등비수열 판별
        else if (common[1] / common[0] == common[2] / common[1]) {
            int r = common[1] / common[0];
            answer = common[common.length - 1] * r;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] common = new int[size];
        for (int i = 0; i < size; i++) {
            common[i] = sc.nextInt();
        }
        System.out.println(solution(common));
    }


}
