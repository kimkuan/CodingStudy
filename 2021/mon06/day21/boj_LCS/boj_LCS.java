package mon06.day21.boj_LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_LCS {
	
	static int[][] LCS;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		LCS = new int[str1.length+1][str2.length+1];
		
		for(int i = 1; i <= str1.length; i++) {
			for(int j = 1; j <= str2.length; j++) {
				if(str1[i-1] == str2[j-1]) 
					LCS[i][j] = LCS[i-1][j-1] + 1; // 현재 문자를 추가하기전 + 1 
				else 
					LCS[i][j] = Math.max(LCS[i][j-1], LCS[i-1][j]);
			}
		}	
		System.out.println(LCS[str1.length][str2.length]);
	}
}