// 치킨 쿠폰
package Level0.Class81_Class90;

import java.util.Scanner;

public class Class86 {

    public static int solution(int chicken) {
       int answer = 0;

       while (chicken >= 10) {
          int service = chicken / 10; // 서비스로 몫 값을 받을 수 있음
          answer += service; // 서비스를 answer에 더함
          // 새로 받은 서비스 치킨 수에 대한 쿠폰 + 이번 반복문에서 교환하고 남은 쿠폰 = 총 쿠폰 수
          chicken = service + (chicken % 10); // 서비스 + 남은 쿠폰
       }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chicken = sc.nextInt();

        System.out.println(solution(chicken));
    }
}
