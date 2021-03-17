package mon03.day15.boj_ZOAC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_ZOAC_이상현 {

	static class Alpha{
		char c;
		int idx;
		int prior;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		
	}
}

// 정렬
// 1) 첫 알파벳은 가장 먼저오는 순서
// 2) 그 이후로는 idx를 확인 -> 첫 알파벳보다 뒤에있고 가장 먼저오는 순서
// 3) 없다면 앞에 있는 애들 중 가장 