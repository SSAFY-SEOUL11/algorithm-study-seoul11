package mon02.day16.boj_야구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_야구_이상현 {
	
	static int N = 8;
	static int maxScore = 0;
	static Integer[] person = new Integer[]{1,2,3,4,5,6,7,8};

	private static boolean next_permutation() {
		int i = N-1;
		while(i > 0 && person[i-1] >= person[i]) --i;
		
		if(i == 0) return false;
		
		int j = N-1;
		while(person[i-1] >= person[j]) --j;
		swap(i-1, j);
		
		int k = N-1;
		while(i < k) swap(i++, k--);
		return true;
	}
	
	private static void swap(int i, int j) {
		int temp = person[i];
		person[i] = person[j];
		person[j] = temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());// 이닝 개수
		int tc = 0;
		int[][] score = new int[T][9];

		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(person);
		
		do {
			int taza = 0; // 이닝이 바뀌어도 타자는 그 다음부터 시작
			int total = 0; // 현재 순열에서 얻을 수 있는 점수
			List<Integer> list = new ArrayList<Integer>(Arrays.asList(person));
			list.add(3, 0); // 1번 타자 추가
			
			for(int inning = 0; inning < T; inning++) {
				// 점수 계산
				int out =  0;
				Queue<Integer> q = new LinkedList<>();
				//ArrayDeque<Integer> q = new ArrayDeque<Integer>();
				while(out < 3) {
					int now = score[inning][list.get(taza%9)]; // 현재 이닝의 타자 / 타자 증가
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
			}
			maxScore = Math.max(total, maxScore);
		}while(next_permutation());
		
		System.out.println(maxScore);
	}
}

/*
 * 4번 타자를 제외하고 순서 정하기
 * 1) 아웃은 홈럼 바로 위에 있는 게 좋다
 * 2) 홈런은 최대한 주자가 많을 때 있는게 좋다
 * 3) 
 */
