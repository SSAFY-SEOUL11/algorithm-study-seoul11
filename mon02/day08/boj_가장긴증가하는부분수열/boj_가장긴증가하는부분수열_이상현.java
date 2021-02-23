package mon02.day08.boj_가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다시 ㅠㅠㅠㅠㅠㅠ

public class boj_가장긴증가하는부분수열_이상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); 	
		int[] arr = new int[n+1];
		int[][] dp = new int[n+1][2]; // [i][0] : i번째에서 만들수 있는 가장 긴 수열의 길이 / [i][1] : 만든 수열에서 가장 작은 값 (자신 포함)
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[n][0] = 1; 
		dp[n][1] = arr[n];
	
		for(int i = n-1; i > 0; i--) { //  거꾸로 접근
			if(arr[i] > dp[i+1][1]) {  // 현재 값이 오른족에 있는 수열 중 가장 작은 값보다 크면
				dp[i][0] = dp[i+1][0];
				dp[i][1] = arr[i];
			}	// dp는 증가하지 않음 (오른쪽에 있는 수열 중 하나가 가장 큰 것)
			else {
				dp[i][0] = dp[i+1][0] + 1; // 본인을 수열에 포함
				dp[i][1] = arr[i]; // 본인이 가장 작게 됨
			}
			
			System.out.println("i : " + i + " -> " + dp[i][0] + " " + dp[i][1]);
		}	
		System.out.print(dp[1][0]);
	}
}
