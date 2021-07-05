package mon07.day05.boj_색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_색종이 {

	static int N;
	static int M = 1001; // 평면의 크기
	static boolean map[][] = new boolean[1002][1002];
	static Paper[] papers;
	static int[] answer;
	
	static class Paper {
		int lc;
		int lr;
		int width;
		int height;
		
		public Paper(int lr, int lc, int height, int width) {
			this.lr = lr;
			this.lc = lc;
			this.height = height;
			this.width = width;
		}		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		papers = new Paper[N];
		answer = new int[N];
		
		for(int i = 0; i < N; i++) {
			// 색종이의 정보 -> (0,0)이 왼쪽위로 오게 생각해보자
			st = new StringTokenizer(br.readLine());
			int lr = Integer.parseInt(st.nextToken()); // 행
			int lc = Integer.parseInt(st.nextToken()); // 열
			int height = Integer.parseInt(st.nextToken()); // 높이
			int width = Integer.parseInt(st.nextToken()); // 너비
			papers[i] = new Paper(lr, lc, height, width);
		}
		
		for(int i = N-1; i >= 0; i--) { // 반대로, 맨 위에 올라오는 색종이부터 접근
			int cnt = 0;
			Paper p = papers[i];
			
			for(int r = 0; r < p.height; r++) { // 색종이가 덮는 면적 계산
				for(int c = 0; c < p.width; c++) {
					int nr = p.lr + r;
					int nc = p.lc + c;
					if(map[nr][nc]) continue;
					map[nr][nc] = true;
					cnt++; // 표면에 보이는 색종이의 면적 ++ 
				}
			}
			answer[i] = cnt;
		}
			
		for(int x : answer) {
			sb.append(x).append("\n");
		}
		System.out.println(sb.toString());
	}
}
