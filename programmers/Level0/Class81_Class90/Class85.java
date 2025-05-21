// 등수 매기기
package Level0.Class81_Class90;

import java.util.*;

public class Class85 {

    public static int[] solution(int[][] score) {
        int[] answer = new int[score.length];

        List<Integer> scoreList = new ArrayList<>();
        for (int[] sc : score) {
            scoreList.add(sc[0] + sc[1]);
        }

        // 내림차순 정렬
        scoreList.sort(Comparator.reverseOrder());

        for (int i = 0; i < score.length; i++) {
            answer[i] = scoreList.indexOf(score[i][0] + score[i][1]) + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[][] score = new int[size][2];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < score[i].length; j++) {
                score[i][j] = sc.nextInt();
            }
        }

        System.out.println(Arrays.toString(solution(score)));
    }
}
