package mon06.day15.boj_미친로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_미친로봇 {

	static int N, size;
	static double result;
	static double[] percentage;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1}; // E, W, S, N
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		size = 2*N+1; // 가운데를 기준으로 N칸만큼 이동 가능해야한다
		percentage = new double[4];
		visited = new boolean[size][size];
		for (int i = 0; i < 4; i++) {
			percentage[i] = Integer.parseInt(st.nextToken()) / (double)100;
		}
		visited[N][N] = true; // 처음 시작하는 위치가 처음 방문한 곳이다
		getSimplePercentage(0, 1, N, N);
		System.out.println(result);
	}
	
	private static void getSimplePercentage(int cnt, double percent, int x, int y) {
		if(cnt == N) {
			result += percent;
			return ;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= size || ny < 0 || ny >= size || visited[nx][ny]) continue;
			visited[nx][ny] = true;
			getSimplePercentage(cnt+1, percent*percentage[i], nx, ny);
			visited[nx][ny] = false;
		}
	}
}
