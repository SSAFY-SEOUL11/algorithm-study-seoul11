package mon02.day22.boj_오등큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_오등큰수_이상현 {
	static int n;
	static int[] arr;
	static int[] f;
	static Stack<String> ans = new Stack<>();
	
	public static void solve() {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = n-1; i >= 0; i--) {
			if(stack.isEmpty()) {
				stack.push(arr[i]);
				ans.push("-1");
			}
			else {
				while(!stack.isEmpty()) {
					int top = stack.peek();
					if(f[arr[i]] < f[top]) { // 현재 arr[i]의 빈도수 보다, 오른쪽 수열 중 가장 왼쪽의, 즉 stack의 top에 있는 값이 빈도수가 높으면
						ans.push(top+"");
						stack.push(arr[i]); // 자기 자신 push
						break;
					}
					else 
						stack.pop(); // 자신보다 작으면 pop
				}
				if(stack.isEmpty()) {
					stack.push(arr[i]);
					ans.push("-1");
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]) max = arr[i];
		}
		
		f = new int[max+1]; // 1부터 max값 까지	
		for(int i = 0; i < n; i++) {
			f[arr[i]]++; // 빈도수
		}
		
		solve();
		
		StringBuilder sb = new StringBuilder();
		while(!ans.isEmpty()) {
			sb.append(ans.pop() + " ");
		}
		System.out.print(sb);
	}
}
