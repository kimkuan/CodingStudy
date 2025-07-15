package y2021.mon10.day12.swea_물놀이를가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class swea_물놀이를가자 {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Place {
		int x;
		int y;
		int cnt;
		
		public Place(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] matrix = new char[N][M];
			int[][] dp = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				matrix[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if(matrix[i][j] == 'L')
						dp[i][j] = Integer.MAX_VALUE;
				}
			}
			
			// BFS�� �̿��� �ִܰŸ� ���ϱ�
			findMove(N, M, matrix, dp);
			
			sb.append("#" + t + " ");
			sb.append(calcalateSum(N, M, dp) + "\n");
		}
		System.out.print(sb.toString());
	}
	
	private static void findMove(int N, int M, char[][] matrix, int[][] dp) {
		ArrayDeque<Place> q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(matrix[i][j] == 'W') // �ϴ�, ������� ��� �־��.
					q.add(new Place(i, j, 0));
			}
		}

		while(!q.isEmpty()) {
			Place place = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = place.x + dx[d];
				int ny = place.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || matrix[nx][ny] == 'W') continue;		

				if(dp[nx][ny] > place.cnt) {
					dp[nx][ny] = place.cnt+1;
					q.add(new Place(nx, ny, place.cnt+1));
				}
			}
		}
		
	}
	
	private static int calcalateSum(int N, int M, int[][] dp) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum += dp[i][j];
			}
		}
		return sum;
	}

}
