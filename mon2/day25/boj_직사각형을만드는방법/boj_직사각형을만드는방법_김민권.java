package mon2.day25.boj_직사각형을만드는방법;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_직사각형을만드는방법_김민권 {

    private static int N, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numOfSquare();
        System.out.println(result);
    }

    private static void numOfSquare() {
        for(int i = 1; i <= Math.sqrt(N); i++) {
            for(int j = i; j <= N; j++) {
                if(i * j <= N) result++;
            }
        }
    }
}
