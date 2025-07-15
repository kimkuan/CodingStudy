package com.mon08.day29.prog_등굣길;

public class prog_등굣길 {
	
	static int m = 4; // 열
	static int n = 3; // 행
	static int[][] puddles = {{2, 4}, {3, 3}};

	public static void main(String[] args) {
		
		long[][] arr = new long[n+1][m+1]; // (1, 1)부터 시작
		
		// 첫번째 '행'에 대해 1로 초기화 
		for (int i = 1; i <= m; i++) { 
			arr[1][i] = 1;
		}
		 // 첫번째 '열'에 대해 1로 초기화 
		for (int i = 1; i <= n; i++) {
			arr[i][1] = 1;
		}
		
		for (int i = 0; i < puddles.length; i++) {
			int x = puddles[i][0];
			int y = puddles[i][1];
			arr[x][y] = -1; // 물 웅덩이
		}
		
		
		for (int i = 2; i <= n; i++) {
			for(int j = 2; j <= m; j++) {
				// arr[i][j-1] & arr[i-1][j] 와 비교할 것임
				
				if(arr[i][j] == -1) continue; // 현재 위치가 물웅덩이면 PASS
				if(arr[i][j-1] == -1 && arr[i-1][j] == -1) continue; // 또는 위아래 모두 물웅덩이면 PASS
                
				if(arr[i][j-1] == -1)
					arr[i][j] = arr[i-1][j];
				else if(arr[i-1][j] == -1)
					arr[i][j] = arr[i][j-1];
				else
					arr[i][j] = (arr[i][j-1] +arr[i-1][j]) % 1000000007;
			}
		}
		System.out.println(arr[n][m]);
	}
}
