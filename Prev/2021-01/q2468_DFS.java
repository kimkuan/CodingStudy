import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* [S1] 안전영역 - 2468번 */

public class q2468_DFS {
	static int n, ans = 0, maxHeight = 0;
	static int[][] arr;
	static boolean[][] check;

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static void dfs(int x, int y, int h) {
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if(arr[nx][ny] > h && check[nx][ny] == false) {
					check[nx][ny] = true;
					dfs(nx, ny, h);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		check = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(arr[i][j], maxHeight);
			}
		}
			
		for(int h=0; h <= maxHeight; h++) {
			int safe = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr[i][j] > h && check[i][j] == false) {
						dfs(i, j, h);
						safe++; // 안전구역
					}
				}
			}
			ans = Math.max(ans, safe);
			
			// 2차원 배열 초기화
			for(int i = 0; i < n; i++) 
				Arrays.fill(check[i], false);
		}	
		
		System.out.print(ans);
	}
}
