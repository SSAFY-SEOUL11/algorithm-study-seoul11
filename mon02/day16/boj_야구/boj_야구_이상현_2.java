package mon02.day16.boj_야구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_야구_이상현_2 {
	static int T;
	static int maxScore = 0;
	static int[][] score;
	static int[] order = new int[9];
	static boolean[] visited = new boolean[9]; // 2번타자부터 8번타자 중 선택;
	
	public static void game(int cnt) {
		if(cnt == 3) {
			order[cnt] = 0; // 1번 타자 추가
			game(cnt+1);
		}
		if(cnt == 9) {
			startGame();
			return;
		}
		for(int i = 1; i <= 8; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			order[cnt] = i;
			game(cnt+1);
			visited[i] = false;
		}
	}
	public static void startGame() {
		ArrayDeque<Integer> q = new ArrayDeque<Integer>(); // for문 밖에서 선언
		int taza = 0; // 이닝이 바뀌어도 타자는 그 다음부터 시작
		int total = 0; // 현재 순열에서 얻을 수 있는 점수
		
		for(int inning = 0; inning < T; inning++) {
			// 점수 계산
			int out =  0;
			while(out < 3) {
				int now = score[inning][order[taza%9]]; // 현재 이닝의 타자 / 타자 증가
				int size = q.size(); // 현재 큐에 담긴 애들
				taza++;
			
				if(now == 0) {
					out++;
					continue;
				}
				for(int j = 0; j < size; j++) {
					int temp = now + q.poll();
					if(temp >= 4) total++; // 점수 증가
					else q.add(temp); 
				}

				if(now == 4) total++; 
				else q.add(now); // 현재 타자 참가
			}
			q.clear();
		}
		maxScore = Math.max(total, maxScore);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());// 이닝 개수
		score = new int[T][9];

		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		game(0);
		
		System.out.println(maxScore);
	}
}
