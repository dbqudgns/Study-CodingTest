package Level1;

import java.util.*;

public class 체육복 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        List<Integer> lostList = new LinkedList<>();
        for (int lostNum : lost) {
            lostList.add(lostNum);
        }

        List<Integer> reserveList = new LinkedList<>();
        for (int reserveNum : reserve) {
            reserveList.add(reserveNum);
        }

        // 1. 해 선택:
        List<Integer> realLost = new ArrayList<>(lostList);
        for (int l : lostList) {
            if (reserveList.contains(l)) {
                realLost.remove((Integer) l);
                reserveList.remove((Integer) l);
                answer++;
            }
        }

        // 2. 적절성 검사
        for (int l : realLost) {
            if (reserveList.contains(l - 1)) {
                reserveList.remove((Integer) (l-1));
                answer++;
            }
            else if (reserveList.contains(l + 1)) {
                reserveList.remove((Integer) (l+1));
                answer++;
            }
        }

        // 3. 해 검사
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lost_size = sc.nextInt();
        int reserve_size = sc.nextInt();

        int[] lost = new int[lost_size];
        int[] reserve = new int[reserve_size];

        for (int i = 0; i < lost.length; i++) {
            lost[i] = sc.nextInt();
        }

        for (int i = 0; i < reserve.length; i++) {
            reserve[i] = sc.nextInt();
        }

        System.out.println(solution(n, lost, reserve));
    }

}
