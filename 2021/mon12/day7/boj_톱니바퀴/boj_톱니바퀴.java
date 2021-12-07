package mon12.day7.boj_톱니바퀴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_톱니바퀴 {

	static int N = 4, M = 8;	// 4개의 톱니바퀴, 8개의 톱니
	static int R;
	static int[][] gears;		// 톱니바퀴의 정보
	static int[] topIndex;		// 각 톱니바퀴의 12시 방향을 가리키는 인덱스
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		gears = new int[N][M];
		topIndex = new int[N];
		
		for (int i = 0; i < N; i++) {
			String gearInfo = br.readLine();
			for (int j = 0; j < M; j++) {
				gears[i][j] = gearInfo.charAt(j) - '0';
			}
		}
		
		// 톱니바퀴 회전
		R = Integer.parseInt(br.readLine());
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;	// 회전시킬 톱니바퀴 (0번부터 시작)
			int dir = Integer.parseInt(st.nextToken());		// 회전 방향

			int currentNum = num;
			int currentDir = dir;
			int currentLeft = gears[num][calculateIndex(topIndex[num], -2)];	// 현재 톱니바퀴의 왼쪽 인덱스
			int currentRight = gears[num][calculateIndex(topIndex[num], +2)]; // 현재 톱니바퀴의 오른쪽 인덱스		
			int nextLeft, nextRight;
			
			// 왼쪽 탐색
			while(currentNum > 0) {
				nextRight = gears[currentNum-1][calculateIndex(topIndex[currentNum-1], +2)]; 	// 왼쪽 톱니바퀴의 오른쪽 인덱스
			
				// 맞닿아있는 부분의 극이 같으면 STOP
				if(currentLeft == nextRight)
					break;
				
				currentLeft = gears[currentNum-1][calculateIndex(topIndex[currentNum-1], -2)]; // 왼쪽 톱니바퀴의 왼쪽 인덱스		
				
				rotate(currentDir*(-1), currentNum-1);  // 왼쪽 톱니바퀴를 회전 시킴
				currentNum--;							// 왼쪽 톱니바퀴가 현재 톱니바퀴가 됨
				currentDir = currentDir * (-1); 		// 현재 회전한 방향의 반대로 
			}
			
			// 현재 톱니바퀴 번호와 방향 초기화
			currentNum = num;
			currentDir = dir;
		
			// 오른쪽 탐색
			while(currentNum < N-1) {
				nextLeft = gears[currentNum+1][calculateIndex(topIndex[currentNum+1], -2)]; 	// 오른쪽 톱니바퀴의 왼쪽 인덱스
				
				// 맞닿아있는 부분의 극이 같으면 STOP
				if(currentRight == nextLeft)
					break;
				
				currentRight = gears[currentNum+1][calculateIndex(topIndex[currentNum+1], +2)]; // 오른쪽 톱니바퀴의 오른쪽 인덱스		
				
				rotate(currentDir*(-1), currentNum+1); 	// 오른쪽 톱니바퀴를 회전 시킴
				currentNum++;							// 오른쪽 톱니바퀴가 현재 톱니바퀴가 됨
				currentDir = currentDir * (-1); 		// 현재 회전한 방향의 반대로 
			}
			
			rotate(dir, num); // 현재 톱니바퀴를 회전 시킴
		}
		
		System.out.println(getResult());
	}
	
	// 총 점수를 계산하는 메소드
	private static int getResult() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			if(gears[i][topIndex[i]] > 0) 
				result += Math.pow(2, i);
		}
		return result;
	}
	
	// 범위내에서 index 값을 계산하는 메소드
	private static int calculateIndex(int topIndex, int move) {
		if(move > 0)
			return topIndex+move >= M ? topIndex-M+move : topIndex+move;
		else
			return topIndex+move < 0 ? topIndex+M+move : topIndex+move; 
	}
	
	// 실제로 회전시켜 topIndex 값을 변경하는 메소드
	private static void rotate(int dir, int num) {		
		// 시계방향으로 회전
		if(dir == 1)
			topIndex[num] = calculateIndex(topIndex[num], -1);
		// 반시계방향으로 회전
		else
			topIndex[num] = calculateIndex(topIndex[num], +1);
	}
}
