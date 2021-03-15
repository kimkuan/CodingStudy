import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [S1] 미로 탐색  */

public class q2178 {
	
	static int m,n ;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1 , 0};
	
	public static int BFS() {
		Queue<int[]> q = new LinkedList<>();
		int ans = 0;
		
		if(arr[0][0] == 1)
			q.add(new int[] {0, 0, 1}); // 시작점
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int cnt = q.peek()[2];
			q.poll();

			if(x == m-1 && y == n-1) {
				ans = cnt; 
				break;
			}
			
			if(visited[x][y] == true)
				continue;
			
			visited[x][y] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
					if(arr[nx][ny] == 1 && visited[nx][ny] == false)
						q.add(new int[] {nx, ny, cnt+1});
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 세로
		n = Integer.parseInt(st.nextToken()); // 가로
		arr = new int[m][n];
		visited = new boolean[m][n];
		
		// 입력
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		// 탐색 (BFS)
		System.out.println(BFS());
	}
}
