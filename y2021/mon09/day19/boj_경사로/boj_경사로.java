package mon09.day19.boj_경사로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_경사로 {

	static int N, L;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		// 탐색
		for (int i = 0; i < 2; i++) { // 가로 or 세로
			for (int j = 0; j < N; j++) {
				if(checkLoad(j, i)) 
					answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	// i : 몇번째 행 또는 열 인지
	// d : 가로 = 0, 세로 = 1
	public static boolean checkLoad(int i, int d) {
		
		boolean[] runway = new boolean[N]; 
		boolean needRunway = false;
		
		// 가로 탐색
		if(d == 0) {	
			// 왼쪽->오른쪽 1차 탐색
			for (int j = 1; j < N; j++) {
				// 높이 차가 2 이상이면 
				int heightGab = map[i][j-1] - map[i][j]; // 내리막
				
				if(heightGab > 1) 
					return false;
				else if(heightGab == 1) 
					needRunway = true;
				
				// 경사로를 만드는 중일 때
				if(needRunway) {
					for(int k = j; k < j + L; k++) {
						if(k < 0 || k >= N) // 범위를 벗어나면 false
							return false;
						if(map[i][k] !=  map[i][j]) // 같은 높이가 L개 나오지 않으면 false
							return false;
						if(runway[k]) // 이미 경사로가 만들어져있으면 false
							return false;
						
						runway[k] = true;
					}
					needRunway = false;
				}
			}
			
			
			// 오른쪽->왼쪽 2차 탐색
			for (int j = N-2; j >= 0; j--) {
				// 높이 차가 2 이상이면 
				int heightGab = map[i][j+1] - map[i][j];
				
				if(heightGab > 1) 
					return false;
				else if(heightGab == 1) 
					needRunway = true;
				
				// 경사로를 만드는 중일 때
				if(needRunway) {
					for(int k = j; k > j - L; k--) {
						if(k < 0 || k > N) // 범위를 벗어나면 false
							return false;
						if(map[i][k] !=  map[i][j]) // 같은 높이가 L개 나오지 않으면 false
							return false;
						if(runway[k]) // 이미 경사로가 만들어져있으면 false
							return false;
						
						runway[k] = true;
					}
					needRunway = false;
				}
			}
			
		}
		// 세로 탐색
		else {
			// 위쪽->아래쪽 1차 탐색
			for (int j = 1; j < N; j++) {
				// 높이 차가 2 이상이면 
				int heightGab = map[j-1][i] - map[j][i]; // 내리막
				
				if(heightGab > 1) 
					return false;
				else if(heightGab == 1) 
					needRunway = true;
				
				// 경사로를 만드는 중일 때
				if(needRunway) {
					for(int k = j; k < j + L; k++) {
						if(k < 0 || k >= N) // 범위를 벗어나면 false
							return false;
						if(map[k][i] !=  map[j][i]) // 같은 높이가 L개 나오지 않으면 false
							return false;
						if(runway[k]) // 이미 경사로가 만들어져있으면 false
							return false;
						
						runway[k] = true;
					}
					needRunway = false;
				}
			}
			
			// 오른쪽->왼쪽 2차 탐색
			for (int j = N-2; j >= 0; j--) {
				// 높이 차가 2 이상이면 
				int heightGab = map[j+1][i] - map[j][i];
				
				if(heightGab > 1) 
					return false;
				else if(heightGab == 1) 
					needRunway = true;
				
				// 경사로를 만드는 중일 때
				if(needRunway) {
					for(int k = j; k > j - L; k--) {
						if(k < 0 || k > N) // 범위를 벗어나면 false
							return false;
						if(map[k][i] !=  map[j][i]) // 같은 높이가 L개 나오지 않으면 false
							return false;
						if(runway[k]) // 이미 경사로가 만들어져있으면 false
							return false;
						
						runway[k] = true;
					}
					needRunway = false;
				}
			}
		}
		
		return true;
	}

}

// 가로 (왼->오른) 방향으로 탐색하면서 
// 1. 경사로가 필요한 지 check
// 	-> 1-1. 높은 칸과 낮은 칸의 차이가 1인지
// 2. 경사로가 필요하다면 경사로를 놓을 충분한 공간이 있는지 check
// 	-> 2-1. 경사로를 놓을 곳에 같은 높이의 칸이 L개 연속되어 있는지.
//	-> 2-2. 범위를 넘어가지 않는 지

// flag를 두어서 경사로가 시작될 때 같은 값은 길이를 count
// 경사로가 만들어지면 해당 


// 그 다음은 (오른 -> 왼) 방향으로 탐색하면서
// 