package mon03.day16.boj_신기한소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_신기한소수_이상현 {
	
	static int N;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = new int[N];

		dfs(0);
		System.out.print(sb);
	}
	
	private static void dfs(int cnt) {
		StringBuilder temp = new StringBuilder();
		
		if(cnt > 0) {// 가지치기		
			for(int i = 0; i < cnt; i++) {
				temp.append(result[i]);
			}
			if(!isSosu(Integer.parseInt(temp.toString()))) // 소수가 아니라면
				return;
		}
		
		if(cnt == N) {
			sb.append(temp.toString());
			sb.append("\n");
			return;
		}
	
		for(int i = 1; i < 10; i++) { // 0이 들어가면 소수가 아니므로 0은 제외
			result[cnt] = i;
			dfs(cnt+1);
		}
	}
	
	private static boolean isSosu(int num) {
		if(num < 2)
			return false;
		
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) // 나누어 떨어지면
				return false;
		}
		return true;
	}
}
