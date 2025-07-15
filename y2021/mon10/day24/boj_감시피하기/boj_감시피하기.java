package y2021.mon10.day24.boj_감시피하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_감시피하기 {

	static int N, M = 3;
	static String answer = "NO";
	static char[][] matrix;
	static ArrayList<Place> students = new ArrayList<>();
	
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
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		matrix = new char[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = st.nextToken().charAt(0);
				if(matrix[i][j] == 'S') // �л��� ��ġ�� ArrayList�� ����
					students.add(new Place(i, j));
			}
		}
		
		setObstacle(0, 0, 0);
		
		System.out.println(answer);
	}

	private static void setObstacle(int sx, int sy, int count) {
		if(count == M) {
			if(ableToMonitor()) // ��� �л����� ������ ���׼� ���ø� ���� �� �ִ���
				answer = "YES";	
			return;
		}
		
		for (int i = sx; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(matrix[i][j] == 'X') {
					matrix[i][j] = 'O';
					setObstacle(i, j, count+1);
					matrix[i][j] = 'X';
				}
			}
		}
	}
	
	private static boolean ableToMonitor() {
		for (int i = 0; i < students.size(); i++) {
			Place place = students.get(i);
			
			// �����¿� Ž�� 
			for(int d = 0; d < 4; d++) {
				int nx = place.x;
				int ny = place.y;
				
				while(true) {
					nx = nx + dx[d];
					ny = ny + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) 
						break;
					
					if(matrix[nx][ny] == 'O')
						break;
					else if(matrix[nx][ny] == 'T') 
						return false; // ���������� �ɸ�.
				}
			}
		}
		
		return true;
	}
}
