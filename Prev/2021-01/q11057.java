import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* [S1] ������ �� - 11057�� */


public class q11057 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][10];
		int ans = 0;
		
		for(int i = 0; i <= 9; i++) {
			dp[1][i] = 1; // �ʱ�ȭ
		}
		
		// dp[2][7] => _7 �� �ǹ���. ���� dp[2][7] = 8 (0~7) = dp[1][0] + dp[1][1] + ... dp[1][7]
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= 9; j++) {
				for(int k = 0; k <= j; k++) {
					dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007; // �����÷ο� ����
				}
			}
		}
		
		for(int i = 0; i <= 9; i++) {
			ans += dp[n][i] % 10007;	
			System.out.println(dp[n][i]);
		}

		System.out.println(ans % 10007);
	}
}
/*
 * �ڸ������� 0~9�� �� �� ����
 * �� �ڸ������� ū ��츸 count
 */