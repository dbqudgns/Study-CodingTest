// 2차원으로 만들기
package Level0.Class61_Class70;

import java.util.Scanner;

public class Class62 {

    public static int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];

        int count = 0;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                answer[i][j] = num_list[count++];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] num_list = new int[size];
        for (int i = 0; i < size; i++) {
            num_list[i] = sc.nextInt();
        }
        int n = sc.nextInt();

        int[][] result = solution(num_list, n);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}
