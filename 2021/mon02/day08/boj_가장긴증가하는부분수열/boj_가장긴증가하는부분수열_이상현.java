package mon02.day08.boj_가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다시 ㅠㅠㅠㅠㅠㅠ

public class boj_가장긴증가하는부분수열_이상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); 	
		int[] arr = new int[n+1];
		int[] dp = new int[n+1]; // [i] : i번째에서 만들수 있는 가장 긴 수열의 길이
		int max = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1; // 1로 초기화
		}
	
		for(int i = n-1; i > 0; i--) { // 오른쪽에서 2번째 값 부터
			int temp = 1;
			for(int j = i+1; j <= n; j++) {
				if(arr[i] < arr[j]) // 자기 보다 높은 수들 중 가장 높은 dp값
					temp = Math.max(temp, dp[j]+1);
			}
			dp[i] = temp;
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
