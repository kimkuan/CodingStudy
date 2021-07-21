package mon07.day21.boj_����Ż��4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_����Ż��4 {

	static int N, M;
	static char[][] map; // ���� ����
	static boolean[][][][] visited; // [rx][ry][bx][by] -> (rx, ry), (bx, by)�� ��ġ�� �� �湮�� ����
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Info{
		int rx;
		int ry;
		int bx;
		int by;
		int count;
		
		public Info(int rx, int ry, int bx, int by, int count) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Info [rx=" + rx + ", ry=" + ry + ", bx=" + bx + ", by=" + by + ", count=" + count + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		int rx = 0, ry = 0, bx = 0, by = 0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'R') { // ���� ������ ����
					rx = i;
					ry = j;
					map[i][j] = '.'; // �� �������� �ʱ�ȭ
				}else if(map[i][j] == 'B') {
					bx = i;
					by = j;
					map[i][j] = '.'; // �� �������� �ʱ�ȭ
				}
			}
		}

		System.out.println(startGame(rx, ry, bx, by));
	}	

	private static int startGame(int redX, int redY, int blueX, int blueY) {
		ArrayDeque<Info> q = new ArrayDeque<>();
		q.add(new Info(redX, redY, blueX, blueY, 0));
		visited[redX][redY][blueX][blueY] = true;
		
		while(!q.isEmpty()) {
			Info info = q.poll();
			
			if(map[info.rx][info.ry] == 'O' && map[info.bx][info.by] != 'O')
				return info.count;
			
			for (int i = 0; i < 4; i++) {
				int nrx = info.rx;
				int nry = info.ry;
				int nbx = info.bx;
				int nby = info.by;
				
				// ���� ���� �̵�
				while(true) {
					if(map[nrx+dx[i]][nry+dy[i]] == '#' || map[nrx][nry] == 'O') // ������ ���̰ų�, ���簡 �����̶�� break
						break;
					nrx += dx[i];
					nry += dy[i];
				}
				
				// �Ķ� ���� �̵�
				while(true) {
					if(map[nbx+dx[i]][nby+dy[i]] == '#' || map[nbx][nby] == 'O') // ������ ���̰ų�, ���簡 �����̶�� break
						break;
					nbx += dx[i];
					nby += dy[i];
				}
				
				
				if(nrx == nbx && nry == nby){ // �� ������ �� ��ǥ���� ���̸� � ������ ���� ���������� �Ǵ��ؾ���
					if(map[nrx][nry] == 'O' && map[nbx][nby] == 'O') // �� ������ ���ۿ� �������� ���
						continue;
					
					// �� ������ ������ ���� �������� �����̴�
					if((Math.abs(nrx - info.rx) + Math.abs(nry - info.ry)) < (Math.abs(nbx - info.bx) + Math.abs(nby - info.by))) {
						nbx -= dx[i];
						nby -= dy[i];
					}else {
						nrx -= dx[i];
						nry -= dy[i];
					}
				}
				
				if(visited[nrx][nry][nbx][nby]) // �̹� �õ��غ� �����̶�� PASS
					continue;
				
				q.add(new Info(nrx, nry, nbx, nby, info.count+1));
				visited[nrx][nry][nbx][nby] = true;
			}
		}
		return -1;
	}
}
