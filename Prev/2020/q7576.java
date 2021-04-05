import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato{
	int x;
	int y;
	int day;
	
	public Tomato(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
}

public class q7576 {
	static int m, n; // 가로 & 세로
	static int min_day = -1;
	static boolean[][] check;
	static int[][] tomato;
	static Queue<Tomato> q;
	
	static int[] xx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
	static int[] yy= {1, 0, -1, 0};
	
	static boolean checkRange(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < m) 
			return true;
		return false;
	}
	
	static boolean checkTomato(){
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(tomato[i][j] == 0) 
					return false;
			}
		}
		return true; // 다 익음
	}
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			Tomato tm =  q.poll();
			int x = tm.x;
			int y = tm.y;
			int day = tm.day;
			
			if(check[x][y] == true) // 이미 방문한 경우 continue로 넘어가기 (이부분 수정했더니 메모리 초과 통과)
				continue;
			
			check[x][y] = true; // 방문완료
			tomato[x][y] = 1; // 익은 토마토로 변경
			
			for(int i = 0; i < 4; i++) {
				int nx = x + xx[i];
				int ny = y + yy[i];
				
				// 토마토가 익지 않은 상태고, 아직 방문하지 않았다면
				if(checkRange(nx, ny) && tomato[nx][ny] == 0 && check[nx][ny] == false)
					q.add(new Tomato(nx, ny, day+1)); 
			}
			
			min_day = min_day < day ? day : min_day ; 
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		check = new boolean[n][m];
		tomato = new int[n][m];
		q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				
				if(tomato[i][j] == 1) 
					q.add(new Tomato(i, j, 0)); // 시작점을 미리 add를 해야 함 (예제 3 만족)
			}
		}
		
		if(checkTomato()){ // 이미 토마토가 모두 익은 상태이면
			System.out.println("0"); // 0 출력
			return;
		}
		
		bfs();
		
		// 모두 수행한 후, 아직도 익지 않은 토마토가 있으면 -1 return
		if(checkTomato() == false) 
			System.out.println("-1");
		else
			System.out.println(min_day);	
	}
}

/*
	1 : 익은 토마토
	0 : 익지 않은 토마토
	-1 : 토마토가 들어있지 않은 칸
	
	입력 : 토마토가 하나 이상 있는 경우 
	
	익지 못하는 경우 : -1으로 둘러쌓임.
*/