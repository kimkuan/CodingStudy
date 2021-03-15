import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q4963 {

	static int[] xx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] yy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int w , h;
	
	public static void dfs(int x, int y, int[][] island ,boolean[][] check) {
		if(check[x][y] == true) // 이미 방문함
			return;
				
		check[x][y] = true; // 방문함
		
		for(int i = 0; i < 8; i++) {
			int next_x = x + xx[i];
			int next_y = y + yy[i];
			
			if(next_x >= 0 && next_x < h && next_y >= 0 && next_y < w) {
				if(island[next_x][next_y] == 1 && check[next_x][next_y] == false) {
					dfs(next_x, next_y, island, check);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			boolean[][] check = new boolean[50][50];
			int[][] island = new int[50][50]; // 섬
			int ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) // while문 exit
				break;
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					island[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// DFS : 모든 노드 검색
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(island[i][j] == 1 && check[i][j] == false) {
						dfs(i, j, island, check);
						ans++;
					}
				}
			}
			System.out.println(ans);	
		}
	}
}