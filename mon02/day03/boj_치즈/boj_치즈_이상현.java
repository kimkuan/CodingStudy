package mon02.day03.boj_치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 가장자리에는 치즈가 올 수 없으니 가장자리와 인접한 치즈들은 C표시된 치즈!
 */
public class boj_치즈_이상현 {
	
	static int M, N;
	static int[] dx = {0, 1, 0, -1}; // 오른, 아래 ,왼, 위
	static int[] dy = {1, 0, -1, 0};
	static int[][] cheeze;
	static boolean[][] visited;
	static int time = 0;
	
	public static int[] countCheeze() {
		int[] result = new int[] {0, 0}; // result[0] : 남은 치즈 개수, result[1] : 녹기 직전의 치즈 개수
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(cheeze[i][j] == 1)
					result[0]++;
				else if(cheeze[i][j] == 2) {
					cheeze[i][j] = 0;
					result[1]++;
				}
			}
		}
		return result; 
	}
	
	public static void melt(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});	
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			if(visited[x][y] == true)
				continue;
			
			visited[x][y] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(cheeze[nx][ny] == 0 && visited[nx][ny] == false)
						q.add(new int[] {nx, ny});
					
					else if(cheeze[nx][ny] == 1) // 아직 닿지 않은 치즈
						cheeze[nx][ny] = 2; // 곧 녹을 치즈
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로길이
		M = Integer.parseInt(st.nextToken()); // 가로길이
		cheeze = new int[N][M];
		visited = new boolean[N][M];
		int time = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				cheeze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true){
			int[] cnt = countCheeze();
			
			if(cnt[0] == 0) {
				System.out.println(time);
				System.out.println(cnt[1]);// 치즈가 없음.
				break;
			}
			melt(0, 0); // 치즈녹음
			time++;
			
			for(int i = 0; i < N; i++) { // 방문 여부 초기화
				Arrays.fill(visited[i], false);
			}
		}
	}
}
