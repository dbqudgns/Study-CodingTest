// 완전 탐색
package 알고리즘_고득점_Kit.완전탐색;

import java.util.*;

public class 모의고사 {

    public static int[] solution(int[] answers) {

        // 1. 각 수포자의 찍기 패턴
        int[] math1 = new int[]{ 1, 2, 3, 4, 5};
        int[] math2 = new int[]{ 2, 1, 2, 3, 2, 4, 2, 5};
        int[] math3 = new int[]{ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int max = 0;

        // 2. 1번 수포자가 맞힌 정답 개수 구하기
        int index = 0;
        int count1 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (math1[index] == answers[i]) {
                count1++;
            }
            index++;
            if (index == math1.length) index = 0;
        }

        if (max <= count1) max = count1;

        // 3. 2번 수포자가 맞힌 정답 개수 구하기
        index = 0;
        int count2 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (math2[index] == answers[i]) {
                count2++;
            }
            index++;
            if (index == math2.length) index = 0;
        }

        if (max <= count2) max = count2;

        // 4. 3번 수포자가 맞힌 정답 개수 구하기
        index = 0;
        int count3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (math3[index] == answers[i]) {
                count3++;
            }
            index++;
            if (index == math3.length) index = 0;
        }

        if (max <= count3) max = count3;

        List<Integer> list = new ArrayList<>();
        if (max == count1) list.add(1);
        if (max == count2) list.add(2);
        if (max == count3) list.add(3);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] answers = new int[size];

        for (int i = 0 ; i < size; i++) {
            answers[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(answers)));

    }

}
