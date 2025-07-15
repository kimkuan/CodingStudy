package y2021.mon08.day01.prog_거리두기확인하기;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class prog_거리두기확인하기 {

	static int N = 5;
	static String[][] places = {
			{"OXPXP", "OPOPX", "OXPXP", "OOOOO", "POXXP"}, 
			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static char[][] map = new char[N][N];
	static ArrayList<int[]> persons = new ArrayList<int[]>();
	
	public static void main(String[] args) {
		int[] answer = new int[N];
		
		for (int t = 0; t < N; t++) {
			initMap(places[t]);
			answer[t] = checkDistance();
		}
		
	}

	private static int checkDistance() {
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		
		for (int i = 0; i < persons.size(); i++) {
			int[] person = persons.get(i);
			q.add(new int[] {person[0], person[1], person[2]}); // �������� ��ġ�� �������� �Ÿ� 2���ϸ� üũ
			
			while(!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				int cnt = q.peek()[2];
				q.poll();
				
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || (person[0] == nx && person[1] == ny)) continue;
					
					if(cnt == 2) 
						continue;
					
					if(map[nx][ny] == 'P') // �Ÿ��� 2�����ε� �� �ȿ� ����� ���� ���
						return 0;
					
					if(map[nx][ny] == 'O') // �Ÿ��� 2 �����ε� ������ �����̺��� ��� (��, ��Ƽ���� ���� ����)
						q.add(new int[] {nx, ny, cnt+1});
				}
			}
		}
		return 1;
	}
	

	private static void initMap(String[] place) {
		persons.clear();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = place[i].charAt(j);
				if(map[i][j] == 'P') {
					persons.add(new int[] {i, j, 0}); // �������� ��ġ�� �Ÿ� ����
				}
			}
		}
	}

}
