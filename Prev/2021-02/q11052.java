import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [S1] ī�� �����ϱ�  */

public class q11052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n+1]; // 1~n����
		int dp[] = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 0;
		}
		
		dp[1] = arr[1];
		
		for(int i = 2; i <= n ; i++) {	
			dp[i] = Math.max(arr[1]*i, dp[i]); // 1������ n���� ����
			dp[i] = Math.max(arr[i], dp[i]); // n���� ������ ����

			for(int j = 1; j <= i/2; j++ ) {
				dp[i] = Math.max(dp[i-j]+ dp[j], dp[i]); // ������ ����
			}
		}
		System.out.println(dp[n]);
	}
}

/* 
 * dp[1] = 1�� ī�常 ���� 1�� ���� �� �ִ� �ִ� �ݾ�
 * dp[2] = 1~2�� ī�常 ���� 2�� ���� �� �ִ� �ִ� �ݾ� // 1+1, 2 
 * dp[3] = 1~3�� ī�带 �Ἥ 3�� ���� �� �ִ� �ִ� �ݾ� // 1*3, 1+2, 3
 * dp[4] = 1~4�� ī�带 �Ἥ 4�� ���� �� �ִ� �ִ� �ݾ� // 1*4, 1+3, 2+2, 4
 * dp[n] = 1~n�� ī�带 �Ἥ 5�� ���� �� �ִ� �ִ� �ݾ�
 * 
 * ��ȭ�� : dp[i] = max (arr[i], dp[i], dp[i-j] + dp[j]);
 */
