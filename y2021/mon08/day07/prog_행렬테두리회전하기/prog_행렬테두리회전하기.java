package y2021.mon08.day07.prog_행렬테두리회전하기;

public class prog_행렬테두리회전하기 {

	static int rows = 3;
	static int columns = 3;
	static int[][] queries = {{1,1,2,2,}, {1,2,2,3}, {2,1,3,2}, {2,2,3,3}};
	static int[][] map = new int[rows+1][columns+1]; // (1, 1)���� ����
	
	public static void main(String[] args) {

		int num = 1;
		for (int i = 1; i <= rows; i++) { 
			for (int j = 1; j <= columns; j++) {
				map[i][j] = num++;
			}
		}
		
		for (int i = 0; i < queries.length; i++) {
			int rs = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
			System.out.println(rs);
			print();
		}
	}
	
	private static int rotate(int x1, int y1, int x2, int y2) {
		int start = map[x1][y1];
		int min = start; // ������ �� �־�α�
		int dx = x1;
		int dy = y1;
		
		while(dx+1 <= x2) { map[dx][dy]=map[++dx][dy]; min = Math.min(min, map[dx][dy]); }
		while(dy+1 <= y2) { map[dx][dy]=map[dx][++dy]; min = Math.min(min, map[dx][dy]); }
		while(dx-1 >= x1) { map[dx][dy]=map[--dx][dy];; min = Math.min(min, map[dx][dy]); }
		while(dy-1 > y1) { map[dx][dy]=map[dx][--dy]; min = Math.min(min, map[dx][dy]); }
		map[dx][dy] = start;
		
		return min;
	}
	
	private static void print() {
		for (int i = 1; i <= rows; i++) { 
			for (int j = 1; j <= columns; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
