package mon02.day09_boj_30번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_30번_이상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int ans = 10; // 루트 노드 (1) * 10
			
			while(num1 != 1 && num2 != 1) {	
				if(num1 == num2) {
					ans = num1 * 10;
					break;
				}
				int gab = Math.abs(num1 - num2);
				
				if(gab >= num1) // 차이보다 작으면 높이가 다른 것 (따라서 큰 수만 나눠주기)
					num2 = num2 % 2 == 0 ? num2/2 : (num2-1)/2;
				else if (gab >= num2)
					num1 = num1 % 2 == 0 ? num1/2 : (num1-1)/2;
				else {
					num1 = num1 % 2 == 0 ? num1/2 : (num1-1)/2;
					num2 = num2 % 2 == 0 ? num2/2 : (num2-1)/2;
				}
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb);
	}

}
