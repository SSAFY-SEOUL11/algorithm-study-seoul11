package mon02.day16.boj_택배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_택배_이상현 {

	static class Box{
		int start;
		int end;
		int weight;
		public Box(int start, int end, int weight) {
			this.start = start; this.end = end; this.weight = weight;
		}
		@Override
		public String toString() {
			return "start, end, weight : " + start + ", " + end + ", " + weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 마을의 개수
		int C = Integer.parseInt(st.nextToken()); // 택배 최대 용량
		int M = Integer.parseInt(br.readLine()); // 박스 정보 개수
		Box[] boxes = new Box[M];
		
		for(int i =  0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
		}

		
	}
}
