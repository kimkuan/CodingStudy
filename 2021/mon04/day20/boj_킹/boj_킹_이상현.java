package mon04.day20.boj_킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8x8 크기의 체스판
// 맨 아래 행이 1, 맨 위에 행이 8
// A1 -> 맨 왼쪽 아래, B1 -> A1의 오른쪽 칸 

// 킹이 돌이 있는 위치로 이동할 때만, 돌도 같은 방향으로 이동
// 만약 체스판을 넘어가면 해당 명령은 넘어감

public class boj_킹_이상현 {
	// R, L, B, T, RT, LT, RB, LB
	static int[] dx = {0,  0,  1, -1, -1, -1, 1, 1};
	static int[] dy = {1, -1,  0,  0,  1, -1, 1, -1};

	static int N = 8;
	static int kx, ky; // 킹의 위치
	static int sx, sy; // 돌의 위치
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String king = st.nextToken(); // 왕의 좌표
		String stone = st.nextToken(); // 돌의 좌표
		int C = Integer.parseInt(st.nextToken()); // 명령의 개수
		
		ky = king.charAt(0) - 'A'; // 열 정보
		kx = 8 - (king.charAt(1) - '0'); // 행 정보 (A1 -> [7][0])
		sy = stone.charAt(0) - 'A'; // 열 정보
		sx = 8 - (stone.charAt(1) - '0'); // 행 정보 (A1 -> [7][0])
		
		for(int i = 0; i < C; i++) {
			String cmd = br.readLine();
			int d = menu(cmd);
			
			int nx = kx + dx[d];
			int ny = ky + dy[d];
			
			// 넘어가버리면 다음 명령으로 넘어감
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

			if(nx == sx && ny == sy) { // 이동한 위치가 돌의 위치랑 같으면 돌도 해당 방향으로 이동
				int nx2 = sx + dx[d];
				int ny2 = sy + dy[d];
				
				// 만약 돌이 넘어가 버리면 위에 명령자체를 넘어가기 때문에 킹도 움직이면 안된다!
				if(nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= N) continue;
				sx = nx2;
				sy = ny2;
			}
			// 돌이 나가지 않는 경우에 킹을 갱신!
			kx = nx; 
			ky = ny;
		}
		StringBuilder sb = new StringBuilder();
		sb.append((char)(ky + 'A')).append(8 - kx);
		sb.append("\n");
		sb.append((char)(sy + 'A')).append(8 - sx);
		System.out.print(sb);
	}
	
	public static int menu(String cmd) {
		switch(cmd) {
		case "R":
			return 0;
		case "L":
			return 1;
		case "B":
			return 2;
		case "T":
			return 3;
		case "RT":
			return 4;
		case "LT":
			return 5;
		case "RB":
			return 6;
		case "LB":
			return 7;	
		}
		return -1;
	}
}
