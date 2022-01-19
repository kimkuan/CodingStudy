package mon01.day19.boj_습격받은도시;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_습격받은도시 {

	static int N;
	static char[][] map;
	static boolean[][] bomb;
	static ArrayList<Node> buildings = new ArrayList<Node>();
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		bomb = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'O')
					buildings.add(new Node(i, j));
				
				else if(map[i][j] == '.') // 빈칸에는 폭탄이 올수 있음 
					bomb[i][j] = true;
			}
		}
		
		for(Node building : buildings) {
			isPossibleBomb(building.x, building.y);
		}
		
		System.out.println(print());
	}
	
	private static void isPossibleBomb(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x;
			int ny = y;
			
			// 'O'를 기준으로 4방향에 있는 빈칸에는 폭탄이 올 수 없음.
			while(true) {
				nx += dx[i];
				ny += dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N)
					break;
				
				if(map[nx][ny] == '.')
					bomb[nx][ny] = false;
				else
					break;
			}
		}
	}
	
	private static String print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 폭탄을 놓을 수 있는 칸이면
				if(map[i][j] == '.' && bomb[i][j])
					map[i][j] = 'B';
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
