import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n+1];
		int dp[] = new int[n+1];
		
		for(int i = 1; i <= n; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		// dp[i] = ���� i��° ���� ���� �� �ִ� �ִ�
		
		dp[1] = arr[1];
		dp[2] = dp[1] + arr[2];
		
		for(int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]);
			// �̹� arr[i]�� �ȸԴ� ��쵵 ������.
			dp[i] = Math.max(dp[i-1], dp[i]);
		}	
		
		for(int i = 1; i <= n; i++) {
			System.out.println(dp[i]);
		}
	}
}

/* ����O 
 * 1) dp[i] = dp[i-3] + arr[i-1] + arr[i]
 * 2) dp[i] = dp[i-3] + arr[i-2] + arr[i];
 * 
 * ����X  
 * 1) dp[i] = dp[i-2] + arr[i-1] 
 */