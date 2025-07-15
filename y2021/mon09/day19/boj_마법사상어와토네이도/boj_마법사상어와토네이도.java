package y2021.mon09.day19.boj_마법사상어와토네이도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_마법사상어와토네이도 {
	static int N;
	static int[][] map;
	static int result = 0;
	
	static int[] dx = {0, 1, 0, -1}; // �� -> �Ʒ� -> ���� -> ��
	static int[] dy = {-1, 0, 1, 0};
	
	static int[][] percent = { // y�� �������� (x, y, percent) (�ٶ��� �������� �� ��)
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
	// �ٶ��� ���������� �� �� -> (0, -2, 5) / (x, y) -> (x, -y) ����
	// �ٶ��� �������� �� �� -> (0, -2, 5) -> (-2, 0, 5)  / (x, y) -> (y, x) ����
	// �ٶ��� �Ʒ������� �� �� -> (0, -2, 5) -> (2, 0, 5) / (x, y) -> (-y, x) ���� 
	

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
			// ���� ����
			else if(num == N && count == 3) {
				break;
			}
		}

		System.out.println(result);
	}

	private static void blowSand(int x, int y, int sand, int d) {
		
		int restSand = sand;
		int[][] temp = new int[percent.length][3];

		// �ٶ��� �������� �� ��
		if(d == 0) {
			for (int i = 0; i < temp.length; i++) {
				temp[i][0] = percent[i][0]; 
				temp[i][1] = percent[i][1];
				temp[i][2] = percent[i][2];
			}
		}
		// �ٶ��� �Ʒ������� �� ��
		else if(d == 1) {
			for (int i = 0; i < temp.length; i++) {
				temp[i][0] = percent[i][1] * (-1); 
				temp[i][1] = percent[i][0];
				temp[i][2] = percent[i][2];
			}
		}
		// �ٶ��� ���������� �� ��
		else if(d == 2) {
			for (int i = 0; i < temp.length; i++) {
				temp[i][0] = percent[i][0]; 
				temp[i][1] = percent[i][1] * (-1);
				temp[i][2] = percent[i][2];
					
			}
		}
		// �ٶ��� �������� �� ��
		else {
			for (int i = 0; i < temp.length; i++) {
				temp[i][0] = percent[i][1]; 
				temp[i][1] = percent[i][0];
				temp[i][2] = percent[i][2];
			}
		}
		
		// �� �̵���Ű��
		for (int i = 0; i < temp.length; i++) {
			int wx = x + temp[i][0];
			int wy = y + temp[i][1];
			int wsand = (int)(sand * ((double)temp[i][2] / 100));
			int inputSand = 0;
			
			// ������ a�ڸ����� ���� ���� ���� �Է�
			if(i == temp.length-1) 
				inputSand = restSand;
			else 
				inputSand = wsand;
			
			// ������ ����� result�� �𷡸� ����
			if(wx < 0 || wx >= N || wy < 0 || wy >= N) 
				result += inputSand;
			else 
				map[wx][wy] += inputSand;
				
			restSand -= wsand;
		}
		
		// ����̵��� ������ �ڸ����� 0
		map[x][y] = 0;
	}
}
