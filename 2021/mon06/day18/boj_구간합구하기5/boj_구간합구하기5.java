package mon06.day18.boj_구간합구하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_구간합구하기5 {

	static int[][] sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		sum = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int value = Integer.parseInt(st.nextToken());
				sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + value;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st =  new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			sb.append(getRangeSum(sx, sy, ex, ey)).append("\n");
		}
		System.out.print(sb);
	}
	
	private static int getRangeSum(int sx, int sy, int ex, int ey) {
		return sum[ex][ey] - sum[sx-1][ey] - sum[ex][sy-1] + sum[sx-1][sy-1];
	} 
}
