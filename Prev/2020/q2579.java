import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class q2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n;
		n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n+1]; // index: 0 ~ n����
		int dp[] = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = arr[1]; 
		
		if(n > 1)
			dp[2] = dp[1] + arr[2];

		for(int i = 3; i <= n; i++) {
			if(dp[i-3] + arr[i-1] >= dp[i-2]) // �� ĭ �� ��
				dp[i] = dp[i-3] + arr[i-1] + arr[i]; // ������ i-3 ����� ����
			else
				dp[i] = dp[i-2] + arr[i];			
		}
		System.out.print(dp[n]);
	}
}
