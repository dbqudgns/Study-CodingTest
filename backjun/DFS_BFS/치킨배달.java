package samsung01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달
{
	static int N;
	static int M;
	static int[][] map;
	
	static List<int[]> chicken;
	static boolean[] visited;

	static List<int[]> house;
	
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		map = new int[N+1][N+1];
		
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		
		for (int i = 1; i < N+1; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
				if (map[i][j] == 2) chicken.add(new int[] {i, j});
				else if (map[i][j] == 1) house.add(new int[] {i, j});
			}
		}
		
		visited = new boolean[chicken.size()];
		
		dfs(0, 0);
		System.out.print(answer);
	}
	
	public static void dfs(int start, int count) {
		
		if (count == M) {
			
			int totalCityDir = 0;
			for (int i = 0; i < house.size(); i++) {
				int minInfos = Integer.MAX_VALUE;
				int[] curHouse = house.get(i);
				
				for (int j = 0; j < chicken.size(); j++) {
					if (visited[j]) {
						int[] curChicken = chicken.get(j);
						int dist = Math.abs(curHouse[0] - curChicken[0]) + Math.abs(curHouse[1] - curChicken[1]);
						minInfos = Math.min(minInfos, dist);
					}
				}
				totalCityDir += minInfos;
			}
			
			answer = Math.min(answer, totalCityDir);
		}
		
		for (int i = start; i < chicken.size(); i++) {
			visited[i] = true;
			dfs(i + 1, count + 1);
			visited[i] = false;
		}
	}
}