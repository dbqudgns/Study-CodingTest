// 정렬
package Level1;

import java.util.*;

public class K번째수 {

    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        int answerIndex = 0;

        // 1. for문을 통해 commands의 각 배열의 i, j, k를 확보한다.
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            // 2. i부터 j의 값을 구하기 위한 임시 배열 선언
            int[] tempArray = new int[j-i+1];
            int index = 0;

            // 3. for문을 통해 임시 배열에 값을 넣는다.
            for (int a = i-1; a < j; a++) {
                tempArray[index++] = array[a];
            }

            Arrays.sort(tempArray);

            // 4. k번째 숫자를 임시 배열에서 구한다.
            answer[answerIndex++] = tempArray[k-1];
        }

        return answer;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arraySize = sc.nextInt();
        int[] array = new int[arraySize];

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        int x = sc.nextInt();
        int y = sc.nextInt();

        int[][] commands = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                commands[i][j] = sc.nextInt();
            }
        }

        System.out.println(Arrays.toString(solution(array, commands)));

    }
}
