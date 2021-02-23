package mon02.day22.boj_구슬탈출4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_구슬탈출4 {

	static int N, M; // 세로, 가로
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1}; // 오 아 왼 위
	static int[] dy = {1, 0, -1, 0};
	static int rx, ry, bx, by, hx, hy;
	static int ans;
	
	static class marble{
		int rx;
		int ry;
		int bx;
		int by;
		int count;
		
		public marble(int rx, int ry, int bx, int by, int count) {
			this.rx = rx; this.ry = ry;
			this.bx = bx; this.by = by;
			this.count = count;
		}

		@Override
		public String toString() {
			return "marble [rx=" + rx + ", ry=" + ry + ", bx=" + bx + ", by=" + by + ", count=" + count + "]";
		}
		
	}
	
	public static void escape() {
		Queue<marble> q = new LinkedList<marble>();
		q.add(new marble(rx, ry, bx, by, 0));
		
		while(!q.isEmpty()) {
			int rx = q.peek().rx; int ry = q.peek().ry;
			int bx = q.peek().bx; int by = q.peek().by;
			int count = q.peek().count;
			System.out.println(q.peek().toString());
			q.poll();

			ans = ans < count ? count : ans; // 최소
			
			if(bx == hx && by == hy) {
				ans = -1;// 실패
				return;
			}
			if(rx == hx && ry == hy) 
				return; // 성공			

			for(int i = 0; i < 4; i++) {
				boolean flag = false; // 큐에 넣을지 말지
				
				int nrx = rx + dx[i]; int nry = ry + dy[i];
				int nbx = bx + dx[i]; int nby = by + dy[i];
				// 빨간 구슬
				if(checkRange(nrx, nry) && !visited[nrx][nry]) {
					while(checkRange(nrx, nry)) {
						nrx += dx[i];
						nry += dy[i]; // 한 방향으로 쭉 이동
					}
					flag = true;
				}
				// 파란 구슬
				if(checkRange(nbx, nby) && !visited[nbx][nby]) {
					while(checkRange(nbx, nby)) {
						nbx += dx[i];
						nby += dy[i]; // 한 방향으로 쭉 이동
					}
					flag = true;
				}
				
				if(flag) {
					if(nrx == nbx && nry == nby) {
						if(i == 0) { // 오른
							if(ry < by) nry--;  
							else nby--;
						}
						else if(i == 1) { // 아래
							if(rx < bx) nrx--;
							else nbx--;
						}
						else if(i == 2) { // 왼
							if(ry < by) nby++;
							else nry++;
						}
						else if(i == 3) { // 위
							if(rx < bx) nrx++;
							else nbx++;
						}
					}
					q.add(new marble(nrx-dx[i], nry-dy[i], nbx-dx[i], nby-dy[i], count+1));
				}
			}
			visited[rx][ry] = true;
			visited[bx][by] = true;
		}
	}
	
	public static boolean checkRange(int x, int y) {
		if(x >= 0 && x < N && y >= 0 && y < M && map[x][y] == '.') // 벽이 아니어야 함
			return true;
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'R') {rx=i;ry=j; map[i][j] = '.';}
				else if(map[i][j] == 'B') {bx=i;by=j; map[i][j] = '.';}
				else if(map[i][j] == 'O') {hx=i;hy=j;}
			}
		}
		escape();
		System.out.print(ans);
	}
}
