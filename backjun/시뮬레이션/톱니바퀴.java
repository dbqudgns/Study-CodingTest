package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 톱니바퀴 {

    static int k;
    static int[][] rowel;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        rowel = new int[5][8];
        for (int i = 1; i <= 4; i++) {
            String[] rowelStr = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                rowel[i][j] = Integer.parseInt(rowelStr[j]);
            }
        }

        k = Integer.parseInt(br.readLine());

        int rowelNum = 0;
        int dir = 0;
        for (int i = 0; i < k; i++) {
            token = new StringTokenizer(br.readLine());
            rowelNum = Integer.parseInt(token.nextToken());
            dir = Integer.parseInt(token.nextToken());

            int[] rotation = new int[5];
            rotation[rowelNum] = dir;

            // 기준 톱니바퀴(rowelNum)의 왼쪽들을 검사
            for (int j = rowelNum; j > 1; j--) {
                if (rowel[j][6] != rowel[j-1][2]) {
                    rotation[j-1] = rotation[j] * -1;
                }
                else break;
            }

            // 기준 톱니바퀴(rowelNum)의 오른쪽을 검사
            for (int j = rowelNum; j < 4; j++) {
                if (rowel[j][2] != rowel[j+1][6]) {
                    rotation[j+1] = rotation[j] * -1;
                }
                else break;
            }

            for (int j = 1; j < 5; j++) {
                if (rotation[j] == 1) {
                    clockWise(j);
                }
                else if (rotation[j] == -1) {
                    counterClockWise(j);
                }
            }
        }

        for (int i = 1; i <= 4; i++) {
            switch(i) {
                case 1: {
                    if (rowel[1][0] == 1) answer += 1;
                    break;
                }
                case 2: {
                    if (rowel[2][0] == 1) answer += 2;
                    break;
                }
                case 3: {
                    if (rowel[3][0] == 1) answer += 4;
                    break;
                }
                case 4: {
                    if (rowel[4][0] == 1) answer += 8;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    // 시계 방향(오른쪽)으로 회전
    public static void clockWise(int rowelNum) {
        int temp = rowel[rowelNum][7];

        for (int i = 7; i > 0; i--) {
            rowel[rowelNum][i] = rowel[rowelNum][i-1];
        }

        rowel[rowelNum][0] = temp;
    }

    // 반시계 방향(왼쪽)으로 회전
    public static void counterClockWise(int rowelNum) {
        int temp = rowel[rowelNum][0];

        for (int i = 0; i < 7; i++) {
            rowel[rowelNum][i] = rowel[rowelNum][i+1];
        }

        rowel[rowelNum][7] = temp;
    }
}