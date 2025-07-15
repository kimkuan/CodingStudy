package y2022.mon01.day02.boj_정수삼각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_정수삼각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int answer = -1;
		
		int[][] arr = new int[N][N];
		int[][] dp = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int j = 0;
			while(st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		
		// 초기화
		dp[0][0] = arr[0][0];
		
		// 대각선 왼쪽, 대각선 오른쪽에 있는 값 중 선택해서 가장 큰 합을 dp 배열에 저장
		for(int i = 1; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j] + arr[i][j];
				}
				else if(j == i) {
					dp[i][j] = dp[i-1][j-1] + arr[i][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
				}
			}
		}
		
		// 마지막 행에서 가장 큰 값 = 선택한 수의 최대 합
		for(int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[N-1][i]);
		}
		
		System.out.println(answer);
	}
}
