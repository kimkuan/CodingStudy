package mon01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1018 {
	static char[][] arr;
	static int n, m;

	public static int chess(int x, int y) {
		int cnt = 0;
	
		//ver1으로 계산
		for(int i = x; i < x+8; i++) {
			for(int j = y; j < y+8; j++) {
				char c = arr[i][j];
				
				if(i % 2 == 0){ // BWBWBWBW
					if(j % 2 == 0 && c == 'W') 
						cnt++;
					else if(j % 2 == 1 && c == 'B')
						cnt++;
				}
				else { // WBWBWBWB
					if(j % 2 == 0 && c == 'B') 
						cnt++;
					else if(j % 2 == 1 && c == 'W')
						cnt++;
				}
			}
		}
		return Math.min(cnt, 64-cnt);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		int min = 50;
		
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}		
		
		for(int i = 0; i < n-7; i++) { // 맨 위, 맨 왼쪽 (시작점) -> 시작점이 될 수 있는 행
			for(int j = 0; j < m-7; j++) { // 시작점이 될 수 있는 열
				int cnt = chess(i, j);
				min = Math.min(min, cnt);
			}
		}
		System.out.println(min);
	}
}
