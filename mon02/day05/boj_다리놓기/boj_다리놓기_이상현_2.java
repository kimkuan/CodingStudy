package mon02.day05.boj_다리놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_다리놓기_이상현_2 {
	
	static int[][] combi = new int[31][31]; // 반복하지 않기 위해 다른 테스트 케이스와 공유

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		for(int i = 0; i <= 30; i++) { // 초기화
			combi[i][0] = 1; // nC0 = 1
			combi[i][i] = 1; // nCn = 1
		}
		
		while(tc++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());		
			R = Math.min(N-R, R); // 더 작은 값으로 계산
			
			for(int i = 2; i <= N; i++) {
				for(int j = 0; j <= R; j++) {
					if(combi[i][j] != 0) continue;
					combi[i][j] = combi[i-1][j-1] + combi[i-1][j];
				}
			}
			
			System.out.println(combi[N][R]);
		}
	}
}
