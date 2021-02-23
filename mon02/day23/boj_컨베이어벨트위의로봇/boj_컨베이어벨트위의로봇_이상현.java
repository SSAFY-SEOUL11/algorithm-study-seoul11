package mon02.day23.boj_컨베이어벨트위의로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_컨베이어벨트위의로봇_이상현 {
	
	static int N, K, len;
	static int start = 0, end = N-1; // 올리는 칸의 인덱스
	static int ans = 0;
	static int[] belt;

	public static void move() {
		ArrayList<Integer> q = new ArrayList<Integer>(); // 로봇들이 위치한 인덱스
		int cnt = 0;
		
		while(cnt < K) {
			ans++; // 단계 시작
			start = (start + len - 1) % len; // 1번. 벨트가 1회 회전
			end = (start + N - 1) % len;
			
			if(q.contains(end))  // 회전했는데 내려가는 칸에 로봇이 도착햇으면
				q.remove(q.indexOf(end));
			
			for(int i = 0; i < q.size();) { // 2번. 로봇들이 한 칸씩이동함
				int idx = q.get(i); // 인덱스
				int nextIdx = (idx+1) % len;
				
				// 내구도가 0보다 크고 해당 위치에 로봇이 없을 때				
				if(belt[nextIdx] > 0 && !q.contains(nextIdx)) { // 0이거나 로봇이 있으면 못 옮김
					q.set(i, nextIdx); // 이동
					belt[nextIdx]--;
					cnt = belt[nextIdx] == 0 ? cnt + 1 : cnt;
					
					if(nextIdx == end) {  // 내려가는 칸에 도착했다면
						q.remove(i);
						continue;
					}
				}
				i++;
			}
			
			if(belt[start] > 0) { // 4번. 새로운 로봇을 올린다
				q.add(start);
				belt[start]--;
				cnt = belt[start] == 0 ? cnt + 1 : cnt;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		len = N*2;
		belt = new int[len]; // 내구도 저장
	
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < len; i++) 
			belt[i] = Integer.parseInt(st.nextToken());
				
		move();
		
		System.out.println(ans);
	}
}
