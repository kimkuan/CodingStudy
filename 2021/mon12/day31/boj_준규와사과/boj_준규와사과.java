package mon12.day31.boj_준규와사과;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_준규와사과 {

	static int N = 5, K;
	static int moveCount, result;
	static boolean[][] map;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		K = Integer.parseInt(br.readLine());
		moveCount = (N*N - K-1); 
		map = new boolean[N+1][N+1];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = true; // 바위로 인해 갈 수 없음
		}
		map[1][1] = true;
		
		move(0, 1, 1);
		
		System.out.println(result);
	}

	private static void move(int count, int x, int y) {
		if(x == N && y == N && count == moveCount) {
			result++;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isRange(nx, ny) || map[nx][ny])
				continue;
			
			map[nx][ny] = true;
			move(count+1, nx, ny);
			map[nx][ny] = false;
		}
	}

	private static boolean isRange(int x, int y) {
		if(x < 1 || x > N || y < 1 || y > N)
			return false;
		return true;
	}
}
