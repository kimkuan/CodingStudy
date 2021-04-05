import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2615 {
	
	static int[][] baduk;
	static int direction[][] = {{0, 1}, {1, 1}, {1, 0}, {-1, 1}};
	static int winner = 0, px, py, lx, ly;
	
	// 해당 좌표가 범위안에 있는지 확인
	static boolean checkRange(int x, int y) {
		if(x >= 0 && x < 19 && y >= 0 && y < 19)
			return true;
		else
			return false;
	}
	
	// color : 확인하고자 하는 바둑의 색깔, dir : 방향, cnt : 확인된 개수
	static void dfs(int x, int y, int[] dir, int cnt) {		
		int color = baduk[x][y];
		int nx = x + dir[0];
		int ny = y + dir[1];
		
		if(checkRange(nx, ny)) {
			if(color == baduk[nx][ny]) 
				dfs(nx, ny, dir, cnt+1);

			else { // 해당 색의 바둑돌이 마지막일 때		
				if(cnt == 5)   // 오목인지 체크
					winner = color;
			}
		}
		else { // 범위를 벗어날 때
			if(cnt == 5)
				winner = color;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		baduk = new int[19][19];
		
		for(int i = 0; i < 19; i++){
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 19; j++) {
				baduk[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < 19; i++){
			for(int j = 0; j < 19; j++) {
				for(int k = 0; k < 4; k++) {
					px = i - direction[k][0]; // 이전 값 체크 (육목 방지용)
					py = j - direction[k][1];
					
					if(baduk[i][j] != 0) {
						if(checkRange(px, py) && baduk[px][py] == baduk[i][j]) // 이전값이 현재와 다를 때 
							continue;
						
						dfs(i, j, direction[k], 1);	
						
						if(winner != 0) {
							lx = i+1; // 제일 왼쪽(or 위쪽) 값 
							ly = j+1;
							System.out.println(winner);
							System.out.println(lx + " " + ly);
							return;
						}
					}
				}
			}
		}
		System.out.println(winner);
	}
}
