package mon2.day18.boj_연속합;

import java.io.*;
import java.util.*;

public class boj_연속합_김민권 {
	
	private static int N;
	private static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());	
		System.out.println(findMaximumSubArray(0, N));
	}

	private static int findMaximumSubArray(int left, int right) {
		if(left >= right - 1) return arr[left];
		
		int mid = (left + right) / 2;
		
		int midLeft = 0; int maxMidLeft = 1000 * -1000;
		for(int i = mid - 1; i >= left; i--) {
			midLeft += arr[i];
			maxMidLeft = Math.max(midLeft, maxMidLeft);			
		}
		
		int midRight = 0; int maxMidRight = 1000 * -1000;
		for(int i = mid; i < right; i++) {
			midRight += arr[i];
			maxMidRight = Math.max(midRight, maxMidRight);			
		}
		
		return Math.max(maxMidLeft + maxMidRight, 
			   Math.max(findMaximumSubArray(left, mid), 
					    findMaximumSubArray(mid, right)));
	}
}