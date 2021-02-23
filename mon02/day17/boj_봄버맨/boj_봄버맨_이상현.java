package mon02.day17.boj_봄버맨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_봄버맨_이상현 {

	static int R, C, N;
	static int[][] map; 
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static ArrayDeque<int[]> q = new ArrayDeque<int[]>();
	
	public static void BFS() {
		int time = 1; // 이미 1초가 지난 시점부터 시작
		
		while(time++ < N) {
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					map[i][j]++;
					if(map[i][j] == 3) q.add(new int[] {i, j});
				}
			}
			
			while(!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				q.poll();
				
				map[x][y] = -1;
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx >= 0 && nx < R && ny >= 0 && ny < C) 
						map[nx][ny] = -1; // 빈칸으로 돌려놓음
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[R][C];
				
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++)  // 폭탄없으면 -1 / 있으면 0 ~ 3
				map[i][j] = str.charAt(j) == 'O' ? 1 : -1; // 원래는 0부터인데 1초동안 아무것도 하지않음 포함				
		}
		
		BFS();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++)  // 폭탄없으면 -1 / 있으면 0 ~ 3
				sb.append(map[i][j] == -1 ? '.' : 'O');
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

/*
 * 1) 가장 처음에 일부 칸에 폭탄을 설치 (0초)
 * 2) 아무것도 안함 (1초)
 * 3) 폭탄이 없는 모든 칸에 폭탄 설치 (2초, 0초)
 * 4) 3초전에 설치한 폭탄 폭발 (3초, 1초)
 * 
 * 5) 폭탄이 없는 모든 칸에 폭탄 설치 (2초, 0초)
 * 6) 3초전에 설치한 폭탄 폭발 (3초, 1초)
 * ... 반복
 * 
 */
