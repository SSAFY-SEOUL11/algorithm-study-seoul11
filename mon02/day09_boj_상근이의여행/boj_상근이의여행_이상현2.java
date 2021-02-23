package mon02.day09_boj_상근이의여행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_상근이의여행_이상현2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); 	
			int m = Integer.parseInt(st.nextToken()); 	
		
			for(int i = 1; i <= m; i++) {
				br.readLine();
			}
        
            System.out.println(n-1);
		}
	}
}