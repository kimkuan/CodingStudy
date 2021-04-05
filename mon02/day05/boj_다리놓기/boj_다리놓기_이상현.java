package mon02.day05.boj_다리놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_다리놓기_이상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());		
			R = Math.min(N-R, R); // 더 작은 값으로 계산
			int[][] combi = new int[N+1][R+1]; // nCr
		
			if(R <= 1) {
				if(R == 0) System.out.println(1);
				else if(R == 1) System.out.println(N);
				continue;
			}
			
			combi[0][0] = 1;
			combi[1][0] = 1;
			combi[1][1] = 1;

			// nCr = n-1 C r + n-1 C r-1
			for(int i = 2; i <= N; i++) {
				for(int j = 0; j <= R; j++) {
					combi[i][j] = (j == 0) ? 1 : combi[i-1][j-1] + combi[i-1][j];
				}
			}
			
			System.out.println(combi[N][R]);
		}
	}
}
