package mon2.day18.boj_MaximumSubarray;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class boj_MaximumSubArray_N_김민권 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) 
				arr[i] = Integer.parseInt(st.nextToken());
			
			sb.append(findMaximumSubArray(N, arr)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int findMaximumSubArray(int N, int[] arr) {
		int result = arr[0];
		int[] arrDp = new int[N];
		arrDp[0] = arr[0];
		
		for(int i = 1; i < N; i++) {
			arrDp[i] = Math.max(0, arrDp[i - 1]) + arr[i];
			result = Math.max(arrDp[i], result);
		}
			
		return result;
	}
	
}
