package todayAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int answer = 0;
	
	static int[] dx = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dy = {1, 0, -1, 0}; // 우 하 좌 상
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int startX, int startY, int count, int totalSum) {
		
		if (count == 4) {
			answer = Math.max(answer, totalSum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			
			int nextX = startX + dx[i];
			int nextY = startY + dy[i];
			
			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
				continue;
			}
			
			// ㅗ 모양 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행 (startX, startY 그대로 호출)
			if (count == 2 && !visited[nextX][nextY]) {
				visited[nextX][nextY] = true;
				dfs(startX, startY, count + 1, totalSum + map[nextX][nextY]);
				visited[nextX][nextY] = false;
			}
			
			if (!visited[nextX][nextY]) {
				visited[nextX][nextY] = true;
				dfs(nextX, nextY, count + 1, totalSum + map[nextX][nextY]);
				visited[nextX][nextY] = false;
			}
		}
	}

}
