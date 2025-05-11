// 주사위의 개수
package Level0.Class41_Class50;

import java.util.Scanner;

public class Class43 {

    public static int solution(int[] box, int n) {
        int answer = 1;
        for (int size : box) {
            int num =  size / n;
            answer *= num;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] box = new int[3];
        for (int i = 0; i < box.length; i++) {
            box[i] = sc.nextInt();
        }

        int n = sc.nextInt();

        System.out.println(solution(box, n));
    }

}
