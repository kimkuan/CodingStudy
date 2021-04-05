package mon02.day25.boj_주사위쌓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_주사위쌓기_이상현 {
	
	static int[] pair = {5, 3, 4, 1, 2, 0}; // pair가 되는 index
	static int[][] dice;
	static int N;
	static int sumMax = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6]; // N개의 주사위
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 6; i++) 
			getMax(i);
		System.out.println(sumMax);
	}
	
	// 첫번재 주사위의 윗면 -> 1~6까지
	public static void getMax(int idx) {
		int sum = 0;
		int down = dice[0][idx];
		int up = dice[0][pair[idx]];// 주사위의 윗면
	
		for(int i = 0; i < N; i++) {
			if(i > 0) {
				for(int j = 0; j < 6; j++) {
					if(dice[i][j] == up) 
						idx = j;
				}
			}
			
			int max = 0;
			down = dice[i][idx];
			up = dice[i][pair[idx]];
						
			for(int j = 0; j < 6; j++) {
				if(dice[i][j] != down && dice[i][j] != up)
					max = Math.max(max, dice[i][j]);
			}	
			sum += max;
		}
		sumMax = Math.max(sum, sumMax);
	}
}
