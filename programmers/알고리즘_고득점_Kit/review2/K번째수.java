package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class K번째수 {

    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        int answerIndex = 0;

        for (int[] command : commands) {

            int[] answerArray = new int[command[1] - command[0] + 1];
            int index = 0;
            for (int i = command[0] - 1; i < command[1]; i++) {
                answerArray[index] = array[i];
                index++;
            }

            Arrays.sort(answerArray);
            answer[answerIndex++] = answerArray[command[2] - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        int size2 = sc.nextInt();
        int[][] commands = new int[size2][3];
        for (int i = 0; i < size2; i++) {
            for (int j = 0; j < 3; j++) {
                commands[i][j] = sc.nextInt();
            }
        }

        System.out.println(Arrays.toString(solution(array, commands)));
    }
}
