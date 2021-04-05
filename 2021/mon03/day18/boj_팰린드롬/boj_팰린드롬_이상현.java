package mon03.day18.boj_팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_팰린드롬_이상현 {

	static int[][] dp; // [s][e]에 대한 팰린드롬 여부 저장
	static int[] number;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N][N];
		number = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) { // idx에 따라서
			number[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = 1;
			if(i > 0) 
				dp[i-1][i] = number[i] == number[i-1] ? 1 : 0;
		}

		for(int i = 2; i < N; i++) { // dp 설정 (크기가 2부터)
			for(int j = 0; j < N-i; j++) {
				int start = j; 
				int end = j+i;
				
				if(number[start] == number[end] && dp[start+1][end-1] == 1)
					dp[start][end] = 1;
				else
					dp[start][end] = 0;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			sb.append(dp[a][b]).append("\n");
		}
		System.out.print(sb);
	}
}
