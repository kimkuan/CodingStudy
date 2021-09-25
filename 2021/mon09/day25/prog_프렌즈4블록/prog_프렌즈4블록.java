package com.mon09.day25.prog_프렌즈4블록;

import java.util.ArrayDeque;

public class prog_프렌즈4블록 {

	static int m = 6; // 높이
	static int n = 6; // 폭
	static String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
	static char[][] boardMap;
	
	static ArrayDeque<int[]> q = new ArrayDeque<>(); 
	
	static int[] dx = {0, 0, 1, 1};
	static int[] dy = {0, 1, 0, 1};
	
	public static void main(String[] args) {

		boardMap = new char[m][n];
		
		for (int i = 0; i < m; i++) {
			boardMap[i] = board[i].toCharArray();
		}
		
		int answer = 0;
		while(!searchBlock()) {
			answer += removeBlock();
			falldown();
		}
		
		System.out.println(answer);
	}
	
	// 지워질 블록이 있는지 탐색 (맨 왼쪽 + 위 칸을 기준으로 2x2 탐색)
	private static boolean searchBlock() {
		
		for (int i = 0; i < m-1; i++) {
			for (int j = 0; j < n-1; j++) {
				
				char leftTop = boardMap[i][j];
				boolean remove = true;
				
				// 빈칸이면 PASS
				if(leftTop == '.')
					continue;
				
				// rightTop, leftBottom, rightBottom과 비교 
				for(int k = 1; k < 4; k++) {
					if(leftTop != boardMap[i+dx[k]][j+dy[k]]) {
						remove = false;
						break;
					}
				}
				
				// 4개의 블록이 모두 같으면 leftTop을 큐에 넣기 (사라지는 블록의 기준)
				if(remove)
					q.add(new int[] {i, j});
			}
		}
		return q.isEmpty();
	}
	
	// 블록 지우기
	private static int removeBlock() {
		int totalCount = 0;
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int k = 0; k < 4; k++) {
				if(boardMap[x+dx[k]][y+dy[k]] != '.') {
					boardMap[x+dx[k]][y+dy[k]] = '.';
					totalCount++;
				}
			}
		}
		return totalCount;
	}
	
	// 블록을 아래로 내림
	private static void falldown() {
		
		ArrayDeque<Character> temp = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			// 아래에서 위 방향으로 블록을 탐색하며 큐에 저장하기
			for(int j = m-1 ; j >= 0; j--) {
				if(boardMap[j][i] == '.')
					continue;
				
				temp.add(boardMap[j][i]);
				boardMap[j][i] = '.';
			}
			
			// 큐에 저장된 블록들을 아래에서부터 채워 넣기
			int j = m-1;
			while(!temp.isEmpty()) {
				boardMap[j][i] = temp.poll();
				j--;
			}
		}
	}
}



// 떨어지는 것은 큐로 구현 
// 아래에서부터 큐에 넣고 다 넣었으면 큐에서 빼서 아래에서부터 채워넣기
