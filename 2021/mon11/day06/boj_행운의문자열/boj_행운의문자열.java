package mon11.day06.boj_행운의문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_행운의문자열 {
	
	static int N;
	static int answer = 0;
	static int[] alpha = new int[26];
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		N = s.length();
		
		for (int i = 0; i < N; i++) {
			alpha[s.charAt(i) - 'a']++; 
		}
		
		dfs(0, -1);
		
		System.out.println(answer);
	}
	
	private static void dfs(int depth, int prev) {
		if(depth == N) {
			answer++;
			return;
		}
		
		for (int i = 0; i < alpha.length; i++) {
			if(prev >= 0 && prev == i)
				continue;
			
			if(alpha[i] ==  0)
				continue;
			alpha[i]--;
			dfs(depth+1, i);
			alpha[i]++;
		}
	}

}
