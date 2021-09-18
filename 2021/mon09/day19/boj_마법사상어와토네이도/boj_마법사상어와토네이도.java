package mon09.day19.boj_마법사상어와토네이도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_마법사상어와토네이도 {
	static int N;
	static int[][] map;
	static int result = 0;
	
	static int[] dx = {0, 1, 0, -1}; // 왼 -> 아래 -> 오른 -> 위
	static int[] dy = {-1, 0, 1, 0};
	
	static int[][] percent = { // y를 기준으로 (x, y, percent) (바람이 왼쪽으로 불 때)
			{-2, 0, 2}, 
			{-1, -1, 10}, 
			{-1, 0, 7},
			{-1, 1, 1},
			{0, -2, 5},
			{1, -1, 10},
			{1, 0, 7},
			{1, 1, 1},
			{2, 0, 2},
			{0, -1, 0}
	};
	// 바람이 오른쪽으로 불 때 -> (0, -2, 5) / (x, y) -> (x, -y) 변경
	// 바람이 위쪽으로 불 때 -> (0, -2, 5) -> (-2, 0, 5)  / (x, y) -> (y, x) 변경
	// 바람이 아래쪽으로 불 때 -> (0, -2, 5) -> (2, 0, 5) / (x, y) -> (-y, x) 변경 
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1, 1, 2, 2, 3, 3, ... N-1, N-1, N, N, N
		int num = 1, count = 0;
		int sx = N/2, sy = N/2, d = 0;
		
		while(true) {	
			for (int i = 0; i < num; i++) {
				sx += dx[d];
				sy += dy[d];
				
				if(sx < 0 || sx >= N || sy < 0 || sy >= N || map[sx][sy] == 0)
					continue;
				
				blowSand(sx, sy, map[sx][sy], d);
			}
			
			count++;
			d = d == 3 ? 0 : d+1;
			
			if(num < N && count == 2) {
				num++;
				count = 0;
			}
			// 종료 조건
			else if(num == N && count == 3) {
				break;
			}
		}

		System.out.println(result);
	}

	private static void blowSand(int x, int y, int sand, int d) {
		
		int restSand = sand;
		int[][] temp = new int[percent.length][3];

		// 바람이 왼쪽으로 불 때
		if(d == 0) {
			for (int i = 0; i < temp.length; i++) {
				temp[i][0] = percent[i][0]; 
				temp[i][1] = percent[i][1];
				temp[i][2] = percent[i][2];
			}
		}
		// 바람이 아래쪽으로 불 때
		else if(d == 1) {
			for (int i = 0; i < temp.length; i++) {
				temp[i][0] = percent[i][1] * (-1); 
				temp[i][1] = percent[i][0];
				temp[i][2] = percent[i][2];
			}
		}
		// 바람이 오른쪽으로 불 때
		else if(d == 2) {
			for (int i = 0; i < temp.length; i++) {
				temp[i][0] = percent[i][0]; 
				temp[i][1] = percent[i][1] * (-1);
				temp[i][2] = percent[i][2];
					
			}
		}
		// 바람이 위쪽으로 불 때
		else {
			for (int i = 0; i < temp.length; i++) {
				temp[i][0] = percent[i][1]; 
				temp[i][1] = percent[i][0];
				temp[i][2] = percent[i][2];
			}
		}
		
		// 모래 이동시키기
		for (int i = 0; i < temp.length; i++) {
			int wx = x + temp[i][0];
			int wy = y + temp[i][1];
			int wsand = (int)(sand * ((double)temp[i][2] / 100));
			int inputSand = 0;
			
			// 마지막 a자리에는 남은 모래의 양을 입력
			if(i == temp.length-1) 
				inputSand = restSand;
			else 
				inputSand = wsand;
			
			// 범위를 벗어나면 result에 모래를 저장
			if(wx < 0 || wx >= N || wy < 0 || wy >= N) 
				result += inputSand;
			else 
				map[wx][wy] += inputSand;
				
			restSand -= wsand;
		}
		
		// 토네이도가 움직인 자리에는 0
		map[x][y] = 0;
	}
}
