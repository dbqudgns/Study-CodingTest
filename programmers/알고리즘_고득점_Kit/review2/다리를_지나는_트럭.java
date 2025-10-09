package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 다리를_지나는_트럭 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        int time = 0;
        int total_weight = 0;
        Queue<Integer> bridge = new ArrayDeque<>();

        for (int truckWeight : truck_weights) {
            while (true) {

                // 1. 다리가 비어있을 경우
                if (bridge.isEmpty()) {
                    bridge.add(truckWeight);
                    total_weight += truckWeight;
                    time++;
                    break;
                }
                // 2. 다리의 길이가 bridge_length 보다 작을 경우
                else if (bridge.size() < bridge_length) {

                    // 2.1 현재 다리 무게와 트럭 무게 합이 기준 무게보다 클 경우
                    if (total_weight + truckWeight > weight) {
                        bridge.add(0);
                        time++;
                    }
                    else { // 2.2 현재 다리 무게와 트럭 무게 합이 기준 무게보다 작거나 같을 경우
                        bridge.add(truckWeight);
                        total_weight += truckWeight;
                        time++;
                        break;
                    }
                }
                else { // 3. 다리의 길이가 bridge_length가 같을 경우
                    total_weight -= bridge.poll();
                }
            }
        }

        return time + bridge_length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bridge_length = sc.nextInt();
        int weight = sc.nextInt();
        int size = sc.nextInt();

        int[] truck_weights = new int[size];
        for (int i = 0; i < size; i++) {
            truck_weights[i] = sc.nextInt();
        }

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

}
