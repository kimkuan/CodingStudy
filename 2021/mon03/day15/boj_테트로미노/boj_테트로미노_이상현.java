package mon03.day15.boj_테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_테트로미노_이상현 {

	static int N, M;
	static int[][] map;
	static int[][][] d = {
			{{0,0}, {0,1}, {0,2}, {0,3}}, // 1번
			{{0,0}, {1,0}, {2,0}, {3,0}}, // 6번
			
			{{0,0}, {0,1}, {1,0}, {1,1}}, // 2번
			
			{{0,0}, {1,0}, {2,0}, {2,1}}, // 3번
			{{0,2}, {1,0}, {1,1}, {1,2}}, // 7번
			{{0,0}, {0,1}, {0,2}, {1,0}}, // 8번
			{{0,0}, {0,1}, {1,1}, {2,1}}, // 9번
		
			{{0,0}, {1,0}, {1,1}, {1,2}}, // 16번
			{{2,0}, {2,1}, {1,1}, {0,1}}, // 17번
			{{0,0}, {0,1}, {0,2}, {1,2}}, // 18번
			{{0,0}, {0,1}, {1,0}, {2,0}}, // 19번
			
			{{0,0}, {1,0}, {1,1}, {2,1}}, // 4번
			{{1,0}, {1,1}, {0,1}, {0,2}}, // 10번
			{{2,0}, {1,0}, {1,1}, {0,1}}, // 11번
			{{0,0}, {0,1}, {1,1}, {1,2}}, // 12번
			
			{{0,0}, {0,1}, {0,2}, {1,1}}, // 5번
			{{1,0}, {1,1}, {1,2}, {0,1}}, // 15번
			{{0,0}, {1,0}, {1,1}, {2,0}}, // 13번
			{{1,0}, {1,1}, {0,1}, {2,1}}, // 14번
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < d.length; k++) {
					int temp = 0;
					boolean flag = false;
					
					for(int m = 0; m < 4; m++) {
						flag = rangeCheck(i+d[k][m][0], j+d[k][m][1]);
						if(!flag) break;
						temp += map[i+d[k][m][0]][j+d[k][m][1]];
					}
					if(flag)
						max = Math.max(max, temp);
				}
			}
		}
		System.out.println(max);
	}
	
	private static boolean rangeCheck(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
}
