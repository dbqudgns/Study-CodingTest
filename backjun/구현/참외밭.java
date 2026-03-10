package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 참외밭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        int maxWidth = 0;
        int maxLength = 0;
        int maxWidthIdx = -1;
        int maxLengthIdx = -1;

        int[] lengths = new int[6];

        StringTokenizer token = null;
        for (int i =0; i < 6; i++) {
            token = new StringTokenizer(br.readLine());

            int direction = Integer.parseInt(token.nextToken());
            int length = Integer.parseInt(token.nextToken());

            lengths[i] = length;

            if (direction == 1 || direction == 2) { // 가로
                if (length > maxWidth) {
                    maxWidth = length;
                    maxWidthIdx = i; // 가장 긴 가로의 인덱스 저장
                }
            }
	        else { // 세로
                if (length > maxLength) {
                    maxLength = length;
                    maxLengthIdx = i; // 가장 긴 세로의 인덱스 저장
                }
            }
        }

        // 전체 넓이
        int totalSquare = maxWidth * maxLength;

        // 가장 긴 변의 인덱스에 +3을 하고 6으로 나눈 나머지가 누적 사각형의 가로와 세로 길이이다.
        int missingWidth = lengths[(maxLengthIdx + 3) % 6];
        int missingLength = lengths[(maxWidthIdx + 3) % 6];
        int missingSquare = missingWidth * missingLength;

        int answerSquare = totalSquare - missingSquare;
        System.out.print(answerSquare * cnt);
    }
}