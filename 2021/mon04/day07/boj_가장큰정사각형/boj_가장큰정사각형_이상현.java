package mon04.day07.boj_가장큰정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_가장큰정사각형_이상현 {

	static int N, M, max = 1; 
	static char[][] arr;
	static int[][] dp; // (x, y)좌표에서 만들 수 있는 최대 정사각형의 한 변의 길이
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
		print();
		System.out.print((int)Math.pow(max, 2));
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		dp = new int[N][M];
		
		boolean one = false;
		for(int i = 0; i < N; i++) { 
			arr[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == '1'){
					dp[i][j] = 1; // 최소 자기자신으로 이루어진 정사각형이 이루어짐
					one = true;
				}
			}
		}
		max = one == true ? 1 : 0; // 1이 없으면 max = 0, 있으면 max = 1
	}
	
	private static void solve() {
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < M; j++) {
				if(arr[i][j] == '1') {
					if(arr[i][j-1] == '0' || arr[i-1][j] == '0' || arr[i-1][j-1] == '0') continue;
					// 2x2 만큼이 모두 다 1이면 
					dp[i][j] +=  Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])); // 셋 중 최솟값 + dp[i][j]
					max = Math.max(dp[i][j], max);
				}
			}
		}
	}
	
	private static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) 
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
	}
}
