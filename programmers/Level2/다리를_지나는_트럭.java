// 큐
package Level2;

import java.util.*;

public class 다리를_지나는_트럭 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        // 1. 다리에 올라온 트럭을 나타내는 Queue 선언
        Queue<Integer> bridge = new ArrayDeque<>();
        int answer = 0; // 모든 트럭이 다리를 건너는데 누적된 시간
        int total_weight = 0; // 현재 다리의 무게

        // 2. for문을 통해 대기 중인 트럭을 일일히 진행
        for (int truck : truck_weights) {

            // 3. 기준 트럭이 다리에 올라가기 위해 while 반복문 진행
            while(true) {

                // 3.1 다리가 비어있을 경우
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    total_weight += truck;
                    answer++;
                    break;
                }
                // 3.2 Queue의 사이즈와 다리의 길이가 같을 경우 (다리의 최대 트럭 개수 비교)
                else if (bridge.size() == bridge_length) {
                    total_weight -= bridge.poll();
                } else { // 3.3 다리가 비어있지 않을 경우
                    // 3.3.1 기준 트럭의 + 현재 다리 무게가 기준 무게보다 작거나 같을 경우
                    if (total_weight + truck <= weight) {
                        bridge.add(truck);
                        total_weight += truck;
                        answer++;
                        break;
                    }
                    // 3.3.2 기준 트럭의 무게 + 현재 다리 무게가 기준 무게보다 클 경우
                    else {
                        bridge.add(0);
                        answer++;
                    }
                }
            }
        }

        // 4. 마지막 트럭이 다리를 완전히 나오는 경우를 고려하여 다리의 길이(bridge_length)를 누적 시간에 더한다.
        return answer + bridge_length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int bridge_length = sc.nextInt();
        int weight = sc.nextInt();
        int size = sc.nextInt();

        int[] truck_weights = new int[size];

        for(int i = 0; i < size; i++) {
            truck_weights[i] = sc.nextInt();
        }

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

}
