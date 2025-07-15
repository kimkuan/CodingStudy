package y2022.mon01.day03.boj_숫자정사각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_숫자정사각형 {

	static int N, M;
	static int answer = 1;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 가로, 세로 중 작은 값이 가장 큰 정사각형의 크기가 된다.
		int maxSize = Math.min(N, M);
		
		// 가장 크기가 큰 경우부터 시작
		for(int i = maxSize; i >= 2; i--) {
			if(isPossible(i)) {
				answer = i * i;
				break;
			}
		}
		System.out.println(answer);
	}
	
	private static boolean isPossible(int size) {
		for (int i = 0; i <= N-size; i++) {
			for (int j = 0; j <= M-size; j++) {				
				// 4개의 꼭짓점에 적힌 수가 모두 같으면 TRUE
				if(map[i][j] == map[i][j+size-1]
				&& map[i][j] == map[i+size-1][j]
				&& map[i][j] == map[i+size-1][j+size-1]) {
					return true;
				}
			}
		}
		return false;
	}

}
