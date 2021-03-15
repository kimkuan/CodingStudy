package mon02.day08.boj_계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_계단오르기_이상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 계단의 수
		int[] arr = new int[n+1]; // 계단에 쓰여있는 점수 저장배열
		int[] dp = new int[n+1];  // 최대 점수
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if(n == 1) {
			System.out.println(arr[1]);
			return;
		}
		dp[0] = 0;
		dp[1] = arr[1]; // 첫 계단은 무조건 밟는 것이 최대 점수
		dp[2] = dp[1] + arr[2]; // 두 번째 계단은 첫번재 두번째 둘 다 밟는 게 최대
		for(int i = 3; i <= n; i++) {
			// 경우1. 바로 전 계단을 밟고 올라온 경우, 연속하면 안되니까 그 전 계단은 밟으면 안됨.
			// 경우2. 2칸 전 계단을 발고 올라온 경우.
			dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
		}
		System.out.println(dp[n]);
	}
}
