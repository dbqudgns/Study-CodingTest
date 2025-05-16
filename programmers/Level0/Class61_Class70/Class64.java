// k의 개수
package Level0.Class61_Class70;

import java.util.Scanner;

public class Class64 {

    public static int solution(int i, int j, int k ) {

        int answer = 0;
        String kString = Integer.toString(k);

        for (int m = i; m <= j; m++) {
            String intString = Integer.toString(m);

            if (intString.contains(kString)) {
                String[] array = intString.split("");

                for (String s : array) {
                    if (s.equals(kString)) answer++;
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solution(i, j, k));
    }

}
