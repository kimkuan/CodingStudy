package mon02.day08.boj_내려가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_내려가기_이상현 {

	public static int maxInNumber(int n1, int n2, int n3) {
		int max = Math.max(n1, n2);
		max = Math.max(max, n3);
		return max;
	}
	
	public static int minInNumber(int n1, int n2, int n3) {
		int min = Math.min(n1, n2);
		min = Math.min(min, n3);
		return min;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // n번의 게임
		int[][] min = new int[n][3]; // 최소 점수
		int[][] max = new int[n][3]; // 최대 점수
		int minScore = Integer.MAX_VALUE;
		int maxScore = -1;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int score1 = Integer.parseInt(st.nextToken()); // 점수 1
			int score2 = Integer.parseInt(st.nextToken()); // 점수 2
			int score3 = Integer.parseInt(st.nextToken()); // 점수 3

			if(i == 0) {
				min[0][0] = max[0][0] = score1; 
				min[0][1] = max[0][1] = score2;
				min[0][2] = max[0][2] = score3;
				continue;
			}
		
			min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + score1;
			max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + score1;
	
			min[i][1] = minInNumber(min[i-1][0], min[i-1][1], min[i-1][2]) + score2;
			max[i][1] = maxInNumber(max[i-1][0], max[i-1][1], max[i-1][2]) + score2;
		
			min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + score3;
			max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + score3;
		}
		
		minScore = minInNumber(min[n-1][0], min[n-1][1], min[n-1][2]);
		maxScore = maxInNumber(max[n-1][0], max[n-1][1], max[n-1][2]);
		
		System.out.print(maxScore  + " " + minScore);
	}
}
