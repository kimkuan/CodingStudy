package mon02.day03.boj_늑대와양;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_늑대와양_이상현 {
	
	static int[] dx = {0, 1, 0, -1}; // 오른, 아래 ,왼, 위
	static int[] dy = {1, 0, -1, 0};
	static char[][] arr;
	static int R, C;
	
	public static boolean rangeCheck(int x, int y) {
		if(x >= 0 && x < R && y >= 0 && y < C)
			return true;
		return false;
	}
	
	public static boolean install(int x, int y){
		int nx, ny;
		
		for(int k = 0; k < 4; k++) {
			// System.out.println(k);
			nx = x + dx[k];
			ny = y + dy[k];
			
			if(rangeCheck(nx, ny)) {
				if(arr[nx][ny] == 'S') 
					return false;
				else if(arr[nx][ny] == 'W')
					continue;
				
				arr[nx][ny] = 'D';
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		boolean flag = true;
		
		for(int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(flag == false)
					break;
				
				if(arr[i][j] == 'W') 
					flag = install(i, j);	
			}
		}
		
		sb.append(flag == true ? 1 : 0).append("\n");
		
		if(flag) {
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
