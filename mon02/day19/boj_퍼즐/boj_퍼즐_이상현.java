package mon02.day19.boj_퍼즐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_퍼즐_이상현 {
	
	static class Info{
		String str; // 덱에 입력받은 문자열
		int idx; // 0의 위치
		int cnt; // 움직인 횟수 
	}
	
	static boolean[][] relation;
	static String result = "123456780";
	static Queue<Integer> q = new LinkedList<Integer>();

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void puzzle() {
		
		Set<String> set = new HashSet<String>();
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			min++;
			System.out.println("x y " + x + " " + y );
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue; 
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[N][M];
		relation = new boolean[9][9]; //0 ~ 8까지 
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) q.add(new int[] {i, j});
			}
		}
		System.out.println("start");
		puzzle();
		System.out.println(min);
	}
}
