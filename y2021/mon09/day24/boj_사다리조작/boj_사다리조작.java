package mon09.day24.boj_사다리조작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_사다리조작 {

	static int N, M, H;
	static int result = Integer.MAX_VALUE;
	static int[][] ladder;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ladder = new int[N+1][H+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
		
			ladder[b][a] = b+1;
			ladder[b+1][a] = b;
		}
		gamestart(0, 1, 1);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	// addCount : 현재까지 추가한 가로선의 개수
	// row : 현재 가로줄의 위치
	// col : 현재 세로줄의 위치
	private static void gamestart(int addCount, int row, int col) {
		// 정답이 3보다 큰 수이면 불가능 하다고 판단한다.
		if(addCount > 3) {
			return ;
		}
				
		// 모든 i번째 세로선의 결과가 i번이 나오는지 체크
		if(success()) {
			result = Math.min(addCount, result);
			return ;
		}
		
		// i번째 가로줄, j번째 세로줄
		for(int i = row; i <= H; i++) {
			for(int j = 1; j < N; j++) {

				if(ladder[j][i] > 0 || ladder[j+1][i] > 0) // 이미 사다리가 존재하면 PASS
					continue;
				
				ladder[j][i] = j+1;
				ladder[j+1][i] = j;
				gamestart(addCount+1, i, j+2);
				ladder[j][i] = 0;
				ladder[j+1][i] = 0;
				
			}
		}
	}
	
	// i번째 세로선의 결과가 i번이 나오는지 체크하는 메소드
	private static boolean success() {
		
		for(int i = 1; i <= N; i++) {
			int currentCol = i; // 현재 세로줄 번호
			int currentRow = 0; // 현재 가로줄 번호
			
			while(true) {
				boolean noMoreLadder = true;
				
				// 현재 가로줄번호보다 큰 수 중에서 가장 작은 수를 뽑기
				for(int j = currentRow; j <= H; j++) {
					if(ladder[currentCol][j] == 0) // 사다리가 없으면 PASS 
						continue;
					
					// 사다리 이동
					currentRow = j+1;
					currentCol = ladder[currentCol][j]; 
					noMoreLadder = false;
					break;
				}
				
				// 더 이상 갈 수 있는 사다리가 없으면 i번으로 시작해서 i번으로 끝나는지 체크
				if(noMoreLadder) {
					if(currentCol != i)
						return false;
					else
						break;
				}
			}
		}
		return true;
	}
	
//	private static void print() {
//		for(int i = 0; i <= N; i++) {
//			for (int j = 0; j <= H; j++) {
//				System.out.print(ladder[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}

// 가로선은 세로선에 연속으로 놓을 수 없다.
// 정답이 3보다 큰 값이면 -1을 출력한다. 또한 불가능한 경우에도 -1을 출력한다.