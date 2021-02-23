package mon02.day09_boj_상근이의여행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_상근이의여행_이상현 {

	static int n, m, min = Integer.MAX_VALUE;
	static int[][] country;
	static boolean[] visited;
	
	public static void travelRec(int first, int cnt, int cntCountry) {
		
		System.out.println("현재 방문 : " + first  + " cnt : " + cnt);
		
		if(visited[first] == false) 
			cntCountry++;
		
		if(n == cntCountry) {
			System.out.println("cnt : " + cnt);
			min = min > cnt ? cnt : min;
			return;
		}
		
		for(int i = first; i <= n; i++) {
			if(country[first][i] == 1) {
				visited[i] = true;
				travelRec(i, cnt+ 1, cntCountry);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); 	
			m = Integer.parseInt(st.nextToken()); 	
			country = new int[n+1][n+1]; // 1~n번 국가
			visited = new boolean[n+1];
		
			for(int i = 1; i <= m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				br.readLine();
				country[from][to] = 1;
				country[to][from] = 1;
			}
			
			for(int i = 1; i <= n; i++) {
				travelRec(i, 1, 1);
				System.out.println(min);
			}
		}
	}
}
