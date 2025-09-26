package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 모의고사 {

    public static int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int max = 0;

        // 1번 수포자가 맞은 개수 구하기
        int answer1 = 0;
        int index1 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[index1]) {
                answer1++;
            }
            index1++;
            if (index1 == student1.length) index1 = 0;
        }

        // 2번 수포자가 맞은 개수 구하기
        int answer2 = 0;
        int index2 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student2[index2]) {
                answer2++;
            }
            index2++;
            if (index2 == student2.length) index2 = 0;
        }

        // 3번 수포자가 맞은 개수 구하기
        int answer3 = 0;
        int index3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student3[index3]) {
                answer3++;
            }
            index3++;
            if (index3 == student3.length) index3 = 0;
        }

        max = Math.max(answer1, answer2);
        max = Math.max(max, answer3);

        List<Integer> list = new ArrayList<>();
        if (max == answer1) list.add(1);
        if (max == answer2) list.add(2);
        if (max == answer3) list.add(3);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] answers = new int[size];

        for (int i = 0; i < size; i++) {
            answers[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(answers)));
    }

}
