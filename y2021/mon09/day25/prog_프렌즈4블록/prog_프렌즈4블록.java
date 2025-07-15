package y2021.mon09.day25.prog_프렌즈4블록;

import java.util.ArrayDeque;

public class prog_프렌즈4블록 {

	static int m = 6; // ����
	static int n = 6; // ��
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
	
	// ������ ����� �ִ��� Ž�� (�� ���� + �� ĭ�� �������� 2x2 Ž��)
	private static boolean searchBlock() {
		
		for (int i = 0; i < m-1; i++) {
			for (int j = 0; j < n-1; j++) {
				
				char leftTop = boardMap[i][j];
				boolean remove = true;
				
				// ��ĭ�̸� PASS
				if(leftTop == '.')
					continue;
				
				// rightTop, leftBottom, rightBottom�� �� 
				for(int k = 1; k < 4; k++) {
					if(leftTop != boardMap[i+dx[k]][j+dy[k]]) {
						remove = false;
						break;
					}
				}
				
				// 4���� ����� ��� ������ leftTop�� ť�� �ֱ� (������� ����� ����)
				if(remove)
					q.add(new int[] {i, j});
			}
		}
		return q.isEmpty();
	}
	
	// ��� �����
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
	
	// ����� �Ʒ��� ����
	private static void falldown() {
		
		ArrayDeque<Character> temp = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			// �Ʒ����� �� �������� ����� Ž���ϸ� ť�� �����ϱ�
			for(int j = m-1 ; j >= 0; j--) {
				if(boardMap[j][i] == '.')
					continue;
				
				temp.add(boardMap[j][i]);
				boardMap[j][i] = '.';
			}
			
			// ť�� ����� ��ϵ��� �Ʒ��������� ä�� �ֱ�
			int j = m-1;
			while(!temp.isEmpty()) {
				boardMap[j][i] = temp.poll();
				j--;
			}
		}
	}
}



// �������� ���� ť�� ���� 
// �Ʒ��������� ť�� �ְ� �� �־����� ť���� ���� �Ʒ��������� ä���ֱ�
