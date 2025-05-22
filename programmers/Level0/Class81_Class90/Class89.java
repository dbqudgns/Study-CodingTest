// 특이한 정렬
package Level0.Class81_Class90;

import java.util.Arrays;
import java.util.Scanner;

public class Class89 {

    public static int[] solution(int[] numlist, int n) {
        int[] answer = {};

        Arrays.sort(numlist);

        for (int i = 0; i < numlist.length; i++) {
            for (int j = 0; j < numlist.length; j++) {
                if (Math.abs(n-numlist[i]) <= Math.abs(n-numlist[j])) {
                    int temp = numlist[i];
                    numlist[i] = numlist[j];
                    numlist[j] = temp;
                    System.out.println(Arrays.toString(numlist));
                }
                else System.out.println(Arrays.toString(numlist));
                System.out.println("====================");
            }
            System.out.println("======한 턴 끝========");
        }

        answer = numlist;

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] numlist = new int[size];
        for (int i = 0; i < size; i++) {
            numlist[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        System.out.println(Arrays.toString(solution(numlist, n)));
    }
}
