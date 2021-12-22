package mon12.day22.boj_주사위쌓기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_주사위쌓기 {

	static int N, result;
	static int[][] dice;
	static int[] opposite = {0, 6, 4, 5, 2, 3, 1}; // 반대에 해당하는 면 (A:1, B:2, C:3, D:4, E:5, F:6)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		dice = new int[N+1][7];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1번 주사위에서 아래쪽에 놓을 면을 선택 
		for (int i = 1; i <= 6; i++) {
			int sum = 0;
			int bottom = i;  // 주사위마다 아래면으로 오는 면의 번호 
			int top = opposite[bottom];
			sum += findMaxValue(1, top, bottom);
			
			// 2번 주사위부터 세로로 줄 세우기
			for(int j = 2; j <= N; j++) {
				bottom = findCorrectSide(j, top);
				top = opposite[bottom];
				sum += findMaxValue(j, top, bottom);
			}
			
			result = Math.max(sum, result);
		}	
		System.out.println(result);
	}

	// 아래 주사위의 맨 윗면과 같은 값을 갖는 현재 주사위의 면 인덱스
	private static int findCorrectSide(int num, int top) {
		int index = 0;
		for (int i = 1; i <= 6; i++) {
			if(dice[num][i] == dice[num-1][top]) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	// top과 bottom을 제외한 면들 중, 가장 최댓값
	private static int findMaxValue(int num, int top, int bottom) {
		int max = 0;
		for (int i = 1; i <= 6; i++) {
			if(i != top && i != bottom)
				max = Math.max(dice[num][i], max);
		}
		return max;
	}
}
