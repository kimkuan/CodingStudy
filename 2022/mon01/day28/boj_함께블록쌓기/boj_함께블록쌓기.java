package mon01.day28.boj_함께블록쌓기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_함께블록쌓기 {

	static int N, M, H;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] blocks = new ArrayList[N+1]; // 각 학생이 갖고있는 블록
		int[][] dp = new int[N+1][H+1];
		
		for(int i = 1; i <= N; i++) {
			blocks[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int height = Integer.parseInt(st.nextToken());
				blocks[i].add(height);
				dp[i][height] = 1;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int h = 1; h <= H; h++) {
				
				dp[i][h] += dp[i-1][h]; // i번 학생이 아무 블록도 사용하지 않는 경우
				
				for(int j = 0; j < blocks[i].size(); j++) {
					int height = blocks[i].get(j);
					
					if(h - height < 0)
						continue;
					
					dp[i][h] += dp[i-1][h - height]; // i번 학생이 블록을 사용하는 경우
				}
			}
		}

		System.out.println(dp[N][H]);
	}
}
