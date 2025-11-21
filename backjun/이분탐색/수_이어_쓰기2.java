package 이분탐색;

import java.util.*;
import java.io.*;

public class 수_이어_쓰기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken()); // ex. 20
        int k = Integer.parseInt(token.nextToken()); // ex. 23

        long target = 0; // 찾을 숫자가 포함된 숫자
        long numLen = 1; // 계속해서 올릴 자릿수
        long numCnt = 9; // 각 자릿수별 숫자 개수 : 9, 90, 900 ~

        while ( k > numCnt * numLen ) { // 23 > 9 => true
            k -= (numLen * numCnt); // 1자리 전체 글자 제거 => k = 23 - 9 = 14
            target += numCnt; // 지나간 숫자 수 => target = 9

            numLen++; // 2
            numCnt *= 10; // 90
        }

        // 지나온 숫자의 개수(target)이 9개 이므로 다음 숫자는 무조건 10이다.
        // 그러므로 현재 자리수의 시작 숫자는 9+1(taget+1) = 10
        // 즉, target+1은 현재 자릿수(numLen 자리, 여기서는 2)의 시작 숫자를 의미한다.
        // (k-1) / numLen => 건너뛸 숫자 개수 = (14-1)/2 = 6
        // 즉, 10에서 6개 숫자를 건너뛰면 target = 16이다.
        // 결국, 여기서 target은 k번째 글자가 포함된 숫자를 의미한다.
        target = (target+1) + (k-1) / numLen;

        // target이 1부터 N 범위 안에 없으면 -1 출력
        if(target > N) {
            System.out.println(-1);
        }
        // k번째 글자가 target의 몇 번째 자리인지 구해야 한다.
        // 자바에서 문자열의 인덱스는 0부터 시작하므로 k에서 1을 빼준다.
        else {
            int idx = (int)((k-1)%numLen);
            System.out.println(String.valueOf(target).charAt(idx));
        }
    }

}
