package mon02.day12.boj_탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_탈출_이상현 {

	static char[][] arr;
	static boolean[][] visited;
	static int N, M, minTime = Integer.MAX_VALUE;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};	
	
	public static void waterCome() {
		Queue<int[]> q = new LinkedList<>();	
		boolean[][] visited2 = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited2[i], false);
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == '*') 
					q.add(new int[] {i, j});
			}
		}
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			if(visited2[x][y]) continue;
			visited2[x][y] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == '.') 
					arr[nx][ny] = '*';
			}
		}
		print();
	}
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i][j]  + " ");
			}
			System.out.println();
		}
	}
	
	public static void escape(int sx, int sy) {
		int currentTime = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{sx,sy,currentTime+1});
		
		while(!q.isEmpty()){
			int x = q.peek()[0];
			int y = q.peek()[1];
			int time = q.peek()[2];
			q.poll();
			
			if(visited[x][y] || arr[x][y] == '*') continue;
			visited[x][y] = true;
			
			if(time > currentTime) { // 시간이 증가할 때 마다 물 들어옴
				waterCome();
				currentTime = time;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(arr[nx][ny] == '.')
						q.add(new int[] {nx, ny, currentTime+1});
					
					else if(arr[nx][ny] == 'D') { // 도착
						minTime = minTime > time ? time : minTime;
						return;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		arr = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++)  
			arr[i] = br.readLine().toCharArray();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 'S') {
					arr[i][j] = '.';
					escape(i, j);
				}
			}
		}
		
		if(minTime == Integer.MAX_VALUE)
			System.out.print("KAKTUS");
		else
			System.out.print(minTime);
	}
}