import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q11058_ans {
	
	static int N;
	static long[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
	
		if(N < 7) {
			System.out.print(N);
			return;
		}
		dp = new long[N+1];
		dp[1] = 1; // A출력
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 4;
		dp[5] = 5;
		dp[6] = 6;
		
		for(int i = 7; i <= N; i++) {
			for(int j = 1; j <= i-3; j++) {
				dp[i] = Math.max(dp[i], dp[i-1] + 1);
				dp[i] = Math.max(dp[i], dp[i-(j+2)]*(j+1));
			}
		}
		System.out.print(dp[N]);
	}
}
/*
 * 출력 후에 3개가 남았을 때 -> 이때부터 복붙 가능
 * 1) 모두 A를 출력하는데 사용 -> i개 => dp[i] = dp[i-1] + 1; 
 * 2) 가장 큰 값을 복붙 => dp[i] = dp[i-3] + dp[i-3];
 * 3) 현재 복붙을  다시 복붙  => dp[i] = dp[i-4] + dp[i-4]*2;
 */