package mon02.day13.boj_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_벽부수고이동하기 {
	static class Pos{
		int x;
		int y;
		int len;
		boolean isCrush;
		boolean[][] visited;

		public Pos(int x, int y, int len, boolean isCrush, boolean[][] visited){
			this.x = x;
			this.y = y;
			this.len = len;
			this.isCrush = isCrush;
			this.visited = new boolean[N][M];

			for(int i = 0; i < N; i++) { // 값 복사
				System.arraycopy(visited[i], 0, this.visited[i], 0, M);
			}
		}
	}
	
	static int N, M, minLen = Integer.MAX_VALUE;
	static char[][] arr;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void crush() {
		
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		q.add(new Pos(0,0,1,false, visit)); // x좌표, y좌표, 이동거리, 벽 부순 개수 
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int len = q.peek().len;
			boolean isCrush = q.peek().isCrush;
			boolean[][] visited = q.peek().visited;
			q.poll();
			
			if(visited[x][y]) continue;
			visited[x][y] = true;
		
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx == N-1 && ny == M-1) {
					minLen = len + 1;
					return;
				}
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
					if(arr[nx][ny] == '1' && !isCrush) // 벽 부수는게 가능하면
						q.add(new Pos(nx, ny, len+1, true, visited));
					else if(arr[nx][ny] == '0')
						q.add(new Pos(nx, ny, len+1, isCrush, visited));
				} 
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		arr = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		crush();
		
		if(minLen == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.print(minLen);
	}
}
