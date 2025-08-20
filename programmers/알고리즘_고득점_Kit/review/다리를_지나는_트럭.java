package 알고리즘_고득점_Kit.review;

import java.util.*;

public class 다리를_지나는_트럭 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        int total_weight = 0;
        int answer = 0;
        Queue<Integer> bridge = new ArrayDeque<>();

        for (int i = 0; i < truck_weights.length; i++) {

            while (true) {

                // 다리가 비어있을 경우
                if (bridge.isEmpty()) {
                    bridge.add(truck_weights[i]);
                    total_weight += truck_weights[i];
                    answer++;
                    break;
                }
                // 다리에 있을 수 있는 트럭의 개수(길이)와 현재 다리의 트럭의 개수가 같을 때
                else if (bridge.size() == bridge_length) {
                    Integer poll = bridge.poll();
                    total_weight -= poll;
                }
                // 다리가 비어있지 않은 경우
                else {

                    // 다리의 현재 무게와 넣을 트럭의 무게 합이 기준 무게를 넘지 않을 경우
                    if (total_weight + truck_weights[i] <= weight) {
                        bridge.add(truck_weights[i]);
                        total_weight += truck_weights[i];
                        answer++;
                        break;
                    }
                    // 다리의 현재 무게와 넣을 트럭의 무게 합이 기준 무게를 넘을 경우
                    else {
                        bridge.add(0);
                        answer++;
                    }
                }
            }
        }
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
