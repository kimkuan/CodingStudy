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
		dp[1] = 1; // A���
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
 * ��� �Ŀ� 3���� ������ �� -> �̶����� ���� ����
 * 1) ��� A�� ����ϴµ� ��� -> i�� => dp[i] = dp[i-1] + 1; 
 * 2) ���� ū ���� ���� => dp[i] = dp[i-3] + dp[i-3];
 * 3) ���� ������  �ٽ� ����  => dp[i] = dp[i-4] + dp[i-4]*2;
 */