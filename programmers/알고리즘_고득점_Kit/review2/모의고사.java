package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 모의고사 {

    public static int[] solution(int[] answers) {
        int[] math1 = {1, 2, 3, 4, 5};
        int[] math2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] math3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] count = new int[3];


        int index1 = 0;
        for (int answer : answers) {
            if (answer == math1[index1++]) {
                count[0]++;
            }

            if (index1 == math1.length) index1 = 0;
        }

        int index2 = 0;
        for (int answer : answers) {
            if (answer == math2[index2++]) {
                count[1]++;
            }

            if (index2 == math2.length) index2 = 0;
        }

        int index3 = 0;
        for (int answer : answers) {
            if (answer == math3[index3++]) {
                count[2]++;
            }

            if (index3 == math3.length) index3 = 0;
        }

        int max = Math.max(count[0], Math.max(count[1], count[2]));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (count[i] == max) {
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);

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

