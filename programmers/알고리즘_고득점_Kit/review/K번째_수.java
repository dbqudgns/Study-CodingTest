package 알고리즘_고득점_Kit.review;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIndex = 0;

        for (int i = 0; i < commands.length; i++) {
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];

            int[] number = new int[b - a + 1];

            int numberIndex = 0;
            for (int j = a-1; j < b; j++) {
                number[numberIndex] = array[j];
                numberIndex++;
            }

            Arrays.sort(number);

            answer[answerIndex] = number[c-1];
            answerIndex++;
        }

        return answer;
    }
}

public class K번째_수 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = sc.nextInt();
        }

        int commandSize= sc.nextInt();
        int[][] commands = new int[commandSize][3];
        for (int i = 0; i < commandSize; i++) {
            for (int j = 0; j < 3; j++) {
                commands[i][j] = sc.nextInt();
            }
        }

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(array, commands)));
    }
}
