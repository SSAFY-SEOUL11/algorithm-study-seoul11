package mon02.day23.boj_반복수열;

import java.awt.BufferCapabilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_반복수열_이상현 {
	static int[] number;
	static int idx;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		number = new int[10];
		list = new ArrayList<Integer>();
		
		for(int i = 0; i <= 9; i++) 
			number[i] = (int) Math.pow(i, P); // i의 P승 저장
				
		list.add(A);
		
		while(true) {
			int sum = 0;
			
			while(A / 10 > 0) {
				sum += number[(A%10)];
				A = A / 10;
			}
			sum += number[A]; // 1의 자리수
			
			if(list.contains(sum)) {
				idx = list.indexOf(sum);
				break;
			}
				
			list.add(sum);
			A = sum;
		}
		System.out.println(idx);
	}	
}
