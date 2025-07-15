package com.mon08.day01.prog_거리두기확인하기;

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
			q.add(new int[] {person[0], person[1], person[2]}); // 지원자의 위치를 기준으로 거리 2이하만 체크
			
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
					
					if(map[nx][ny] == 'P') // 거리가 2이하인데 그 안에 사람이 있을 경우
						return 0;
					
					if(map[nx][ny] == 'O') // 거리가 2 이하인데 다음이 빈테이블일 경우 (즉, 파티션은 넣지 않음)
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
					persons.add(new int[] {i, j, 0}); // 응시자의 위치와 거리 저장
				}
			}
		}
	}

}
