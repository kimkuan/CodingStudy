package mon09.day17.boj_��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_�� {
	
	static int N, K, L;
	static int[][] map;
	static ArrayDeque<Place> log = new ArrayDeque<>();
	static ArrayDeque<Direction> q = new ArrayDeque<>();

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Place{
		int x;
		int y;
		
		public Place(int x, int y) {
			this.x = x;
			this.y = y;
		} 
	}
	
	static class Direction{
		int sec;
		char dir;
		
		public Direction(int sec, char dir) {
			this.sec = sec;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1]; // (1, 1)���� ����. ���� ������ 1, ����� ������ 2
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 2;
		}
		
		L = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			q.add(new Direction(sec, dir));
		}
		
		// ���� ����!
		int sx = 1, sy = 1, d = 0; // ���� ���� ��ġ�� ����
		int time = 0;
		
		map[sx][sy] = 1;
		log.add(new Place(sx, sy));
		
		while(true) {
			time++;
			
			sx = sx + dx[d];
			sy = sy + dy[d];
			
			// ���� �Ѿ�� break
			if(sx <= 0 || sx > N || sy <= 0 || sy > N)
				break;
			
			// ����� ������ ���� ������ ���̱� 
			if(map[sx][sy] == 0) {
				if(!log.isEmpty()){
					Place tail = log.poll();
					map[tail.x][tail.y] = 0;
				}
			}else if(map[sx][sy] == 1) {
				break;
			}
			
			map[sx][sy] = 1;
			log.add(new Place(sx, sy));
			
			// ���� ���� �ð����κ��� X�ʰ� '����' �ڿ� ���� ȸ��
			if(!q.isEmpty() && q.peek().sec == time) {
				Direction temp = q.poll();
				
				if(temp.dir == 'D') 
					d = d == 3 ? 0 : d+1; 
				else 
					d = d == 0 ? 3 : d-1;
			}
		}
		System.out.println(time);
	}
}

