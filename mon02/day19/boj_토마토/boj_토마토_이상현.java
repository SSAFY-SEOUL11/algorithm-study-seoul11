package mon02.day19.boj_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_토마토_이상현 {

	static int M, N, minDay = 0; // 가로, 세로
	static int[][] tomato;
	static Queue<int[]> q = new LinkedList<int[]>();
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void yummyTomato() {
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int day = q.peek()[2];
			q.poll();
						
			if(tomato[x][y] > 1) continue; // 이미 방문함
			tomato[x][y] = day;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || tomato[nx][ny] != 0) continue; 
				q.add(new int[] {nx, ny, day+1});
			}
			minDay = minDay < day ? day : minDay;
		}		
		if(!isAvailable())
			System.out.println(-1);
		else
			System.out.println(minDay-1);
	}
	
	public static boolean isAvailable() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tomato[i][j] == 0)
					return false; // 불가능
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] == 1) q.add(new int[] {i, j, 1}); // 방문제외를 위해
			}
		}
		
		yummyTomato();
	}
}
