package mon02.day15.boj_아기상어2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_아기상어2 {

	static int N, M;
	static int MAX = Integer.MIN_VALUE; // 최대 거리 
	static int[][] shark;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1}; // 오위 - 오 - 아래 ...
	static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
	
	public static boolean rangeCheck(int x, int y) {
		if(x >= 0 && x < N && y >= 0 && y < M)
			return true;
		return false;
	}
	
	public static int safe(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sx, sy, 0});
		
		for(int i = 0; i < N; i++) 
			Arrays.fill(visited[i], false);
	
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int cnt = q.peek()[2];
			q.poll();

			if(shark[x][y] == 1) { // 가장 가까운 상어 find
				return cnt;
			}
			if(visited[x][y]) continue;
			visited[x][y] = true;
			
			for(int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(rangeCheck(nx, ny) && !visited[nx][ny]) { // 이미 한번 체크했으면 중복방지
					q.add(new int[] {nx, ny, cnt+1});
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		shark = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				shark[i][j] = Integer.parseInt(st.nextToken(), ' ');
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(shark[i][j] == 0) 
					MAX = Math.max(safe(i, j), MAX);
			}
		}
		
		System.out.print(MAX);
	}
}
