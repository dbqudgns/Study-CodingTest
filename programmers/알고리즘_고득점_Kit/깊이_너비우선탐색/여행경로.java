package 알고리즘_고득점_Kit.깊이_너비우선탐색;

import java.util.*;

public class 여행경로 {

    static class Airport {
        String start;
        String end;
        boolean visited;

        public Airport(String start, String end, boolean visited) {
            this.start = start;
            this.end = end;
            this.visited = visited;
        }

        @Override
        public String toString() {
            return "Airport{" +
                    "start='" + start + '\'' +
                    ", end='" + end + '\'' +
                    ", visited=" + visited +
                    '}';
        }
    }

    static List<Airport> airportList;
    static boolean finish;

    public static String[] solution(String[][] tickets) {

        String[] answer = new String[tickets.length + 1];
        airportList = new ArrayList<>();
        finish = false;
        int index = 0;

        // 1. airportList에 Airport 객체 저장
        for (String[] ticket : tickets) {
            airportList.add(new Airport(ticket[0], ticket[1], false));
        }

        // 2. DFS 수행
        answer[index] = "ICN";
        dfs("ICN", answer, index + 1);

        return answer;
    }

    public static void dfs(String start, String[] answer, int index) {

       // System.out.println(start);

        // index가 answer 길이와 같다면 재귀함수 종료
        if (index == answer.length) {
            finish = true;
            return;
        }

        // start 공항에서 어디 공항으로 갈지 nextList에 저장
        List<Airport> nextList = new ArrayList<>();
        for (Airport airport : airportList) {
            if (start.equals(airport.start) && !airport.visited) {
                nextList.add(airport);
            }
        }

        // 만약 nextList가 비어있다면 갈 공항이 없으므로 종료
        if (nextList.isEmpty()) {
            return;
        }

        // 갈 수 있는 공항이 2개 이상이라면 문자열 오름차순 정렬
        nextList.sort((a1, a2) -> a1.end.compareTo(a2.end));

        // 갈 수 있는 공항 하나씩 dfs 수행
        for (int i = 0; i < nextList.size(); i++) {
            Airport nextAirport = nextList.get(i);

            // System.out.println(nextAirport.toString());

            nextAirport.visited = true;
            answer[index] = nextAirport.end;
            dfs(nextAirport.end, answer, index + 1);

            if (finish) {
                return;
            }

            nextAirport.visited = false; // 백트래킹 : 기준 공항(nextAirport.end)에서 다음 공항으로 갈 경로가 없을 때

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String[][] tickets = new String[size][2];

        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < tickets[i].length; j++) {
                tickets[i][j] = sc.next();
            }
        }

        System.out.println(Arrays.toString(solution(tickets)));

    }

}
