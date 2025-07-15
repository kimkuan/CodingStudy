package y2021.mon06.day11.행렬_테두리_회전하기;

public class 행렬_테두리_회전하기 {
	
	static int INF = Integer.MAX_VALUE;
	static int rows = 6;
	static int columns = 6;
	static int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};
	static int[][] map;
	
	public static void main(String[] args) {
		map = new int[rows][columns];
		
		int num = 1;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				map[i][j] = num++;
			}
		}
		for(int i = 0; i < queries.length; i++) {
			System.out.println(rotate(queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1));
		}
	}
	
	private static int rotate(int sx, int sy, int ex, int ey) {
		int startNum = map[sx][sy];
		int min = startNum;
		int x = sx, y = sy;
		
		// 아래 -> 위
		while(x+1 <= ex) { 
			min = Math.min(min, map[x+1][y]);
			map[x][y] = map[x+1][y];
			x++;
		}
		// 오른 -> 왼
		while(y+1 <= ey) { 
			min = Math.min(min, map[x][y+1]);
			map[x][y] = map[x][y+1];
			y++;
		}
		// 위 -> 아래
		while(x-1 >= sx) { 
			min = Math.min(min, map[x-1][y]);
			map[x][y] = map[x-1][y];
			x--;
		}
		// 왼 -> 오른
		while(y-1 >= sy) { 
			min = Math.min(min, map[x][y-1]);
			map[x][y] = map[x][y-1];
			y--;
		}
		map[sx][sy+1] = startNum; 
	
		return min;
	}

	private static void print() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
