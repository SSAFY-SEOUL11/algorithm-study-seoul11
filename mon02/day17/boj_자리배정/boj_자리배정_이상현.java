package mon02.day17.boj_자리배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_자리배정_이상현 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		boolean[][] visited = new boolean[R][C];
		
		int K = Integer.parseInt(br.readLine()); // K번 대기번호를 가진 손님이 앉을 좌석은?
		int cnt = 0, dir = 0;
		int x = R-1, y = 0;

		while(cnt++ < K-1) {
			visited[x][y] = true;
			
			if(dir == 0 && x-1 >= 0 && !visited[x-1][y]) x--;
			else if (dir == 1 && y+1 < C  && !visited[x][y+1]) y++;
			else if(dir == 2 && x+1 < R && !visited[x+1][y]) x++;
			else if(dir == 3 && y-1 >= 0 && !visited[x][y-1]) y--;
			else { dir++; cnt--;}

			dir=dir%4;
		}
		System.out.println((y+1)+" " + (C-(x+1)));
	}
}
