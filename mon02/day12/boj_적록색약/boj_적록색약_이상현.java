package mon02.day12.boj_적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj_적록색약_이상현 {

	static char[][] arr;
	static boolean[][] visited;
	static int N;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void checkGroup(int x, int y, boolean weak) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			if(visited[x][y]) // 이미 방문했으면
				continue;
			
			visited[x][y] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(arr[x][y] == arr[nx][ny]) // 같으면 같은 그룹
						q.add(new int[] {nx, ny});
					
					else if(weak) { // 색약이면
						if((arr[x][y] == 'R' && arr[nx][ny] == 'G') || (arr[x][y] == 'G' && arr[nx][ny] == 'R'))
							q.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int notWeak = 0, weak = 0;
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) 
			arr[i] = br.readLine().toCharArray();
	
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					checkGroup(i, j, false);
					notWeak++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) 
			Arrays.fill(visited[i], false); // 초기화		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					checkGroup(i, j, true);
					weak++;
				}
			}
		}
		
		System.out.println(notWeak + " " + weak);
	}
}
