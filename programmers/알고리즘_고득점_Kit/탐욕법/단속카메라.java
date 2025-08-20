package 알고리즘_고득점_Kit.탐욕법;

import java.util.*;

public class 단속카메라 {

    public static int solution(int[][] routes) {
        int answer = 0;
        int input = -30001;

        // 차량들의 진출 지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, (r1, r2) -> {
            return r1[1] - r2[1];
        });


        for (int route[] : routes) {
            // 현재 차량의 진입 지점이 이전 카메라 범위 밖에 있으면 새 카메라를 설치한다.
            if (input < route[0]) {
                answer++; // 카메라 수 증가
                input = route[1]; // 현재 차량의 진출 지점에 카메라 설치
            }

        }

        return answer; // 최소 카메라 수 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int car_size = sc.nextInt();

        int[][] routes = new int[car_size][2];

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                routes[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(routes));
    }

}
