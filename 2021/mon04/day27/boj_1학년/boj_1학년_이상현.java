package mon04.day27.boj_1학년;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1학년_이상현 {

	static int N, T;
	static int[] number;
	static long[][] dp;

	// 시간초과 -> DP 이용
	// DP[sum][idx] : idx번째에서 sum이라는 값을 만든 적이 있으면 return
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		dp = new long[21][N]; // idx까지 계산했을 때 0~19라는 값을 이전에 만든 횟수 
		
		for(int i = 0; i < 21; i++) {
			Arrays.fill(dp[i], -1); // 방문한적없으면 -1
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		T = number[N-1]; // 등호 다음에 나오는 값
		
		System.out.println(combination(1, number[0]));
	}
	public static long combination(int cnt, int sum){
		// 마지막에 target과 같은 값이 나오면 1 리턴
		if(cnt == N-1){
            if(sum == T) return 1;
            else return 0;
        }
		
		if(dp[sum][cnt] > -1) // 이전에 방문한적있으면
        	return dp[sum][cnt];
		
		long ans = 0; // 조건을 만족하면서 만들 수 있는 경우의 수
		
		// 도중에 음수가 나오면 만들수없는 등식
		if(sum+number[cnt] <= 20) {
			ans += combination(cnt+1, sum+number[cnt]);		
		}
		if(sum-number[cnt] >= 0) {
			ans += combination(cnt+1, sum-number[cnt]);
		} 
		dp[sum][cnt] = ans;
		
		return dp[sum][cnt];
    }
}
