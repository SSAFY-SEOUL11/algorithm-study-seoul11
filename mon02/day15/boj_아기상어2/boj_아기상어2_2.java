package mon02.day15.boj_아기상어2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_아기상어2_2 {

	static int N, M;
	static int MAX = 0; // 최대 거리 
	static int[][] shark;
	static int[][] visited;
	static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1}; // 오위 - 오 - 아래 ...
	static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
	
	public static boolean rangeCheck(int x, int y) {
		if(x >= 0 && x < N && y >= 0 && y < M)
			return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<int[]> q = new LinkedList<>();
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		shark = new int[N][M];
		visited = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				shark[i][j] = Integer.parseInt(st.nextToken());
				if(shark[i][j] == 1) {
					q.add(new int[] {i, j});
					visited[i][j] = 0; // 방문했으면 1, 거리 저장
				}
			}
		}
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(rangeCheck(nx, ny) && visited[nx][ny] == 0 && shark[nx][ny] == 0) {
					q.add(new int[] {nx, ny});
					visited[nx][ny] = visited[x][y] + 1; // 현재까지 거리에서 + 1 
					MAX = visited[nx][ny];
				}
			}
		}
		
		System.out.print(MAX);
	}
}
