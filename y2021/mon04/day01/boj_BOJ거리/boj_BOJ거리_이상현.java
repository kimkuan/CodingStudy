package y2021.mon04.day01.boj_BOJ거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_BOJ거리_이상현 {
	
	static int N;
	static char[] arr;
	static int[] dp;
	static int INF = 987654321;
	static int answer = INF;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		dp = new int[N];
		Arrays.fill(dp, -1); // 아직 방문하지 않은 곳은 -1로 설정
		
		jump(0);
		System.out.println(dp[N-1] == 0 ? dp[0] : -1);
	}
	
	public static int jump(int cnt) { // return : dp값
		if(cnt == N-1) { 
			dp[cnt] = 0; // 방문 여부
			return 0;
		}
		
		if(dp[cnt] != -1) // 이미 방문한 곳 = 최솟값을 구한 곳 (중복 방지)
			return dp[cnt]; 
		dp[cnt] = INF; // -1이면 아직 방문하지 않은 곳이므로 min 계산을 위해 초기화 (단, MAX_VALUE는 오버플로우 발생가능함)
		
		char next = next(arr[cnt]);	
		for(int i = cnt+1; i < N; i++) {
			if(arr[i] == next) {
				// 비용 = 현재 위치에서 다음 위치로 이동하는데 걸리는 비용 + 다음 위치에서 도착지까지의 비용
				dp[cnt] = Math.min(dp[cnt], jump(i) + (i-cnt) * (i-cnt));
			}
		}
		return dp[cnt];
	}
	
	public static char next(char c) {
		if(c == 'B') return 'O';
		else if(c == 'O') return 'J';
		else return 'B';
	}
}
