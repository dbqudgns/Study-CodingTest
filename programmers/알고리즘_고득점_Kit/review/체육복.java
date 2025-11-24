package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 체육복 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        List<Integer> lostList = new ArrayList<>();
        for (int l : lost) {
            lostList.add(l);
        }

        List<Integer> reserveList = new ArrayList<>();
        for (int r : reserve) {
            reserveList.add(r);
        }

        // 1. 해 선택 : 여벌 체육복을 가져온 학생이 체육복을 도난 당했을 경우
        // 해당 학생 번호를 reserve에서 제거하고 answer++;
        List<Integer> realLost = new ArrayList<>(lostList);
        for (int l : lostList) {
            if (reserveList.contains(l)) {
                realLost.remove((Integer) l);
                reserveList.remove((Integer) l);
                answer++;
            }
        }

        // 2. 적절성 검사 : realLost에 남은 학생번호로 앞(+), 뒤(-)로 계산하여
        // reserveList에 있는 번호와 일치하는지 확인한 후 일치하면 reserveList에서 제거 후 answer++;
        for (int l : realLost) {
            if (reserveList.contains(l-1)) {
                reserveList.remove((Integer)(l-1));
                answer++;
            }
            else if (reserveList.contains(l+1)) {
                reserveList.remove((Integer)(l+1));
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
