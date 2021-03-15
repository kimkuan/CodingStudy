import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11053 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n]; // Ž���� ������ �����ϴ� ��
		int max = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		for(int i = 0; i < n; i++) { // �ִ� ������ ���ؼ��� ũ�ٰ� �� ������ �ȵ�
			int cnt = 0;
			for(int j = i; j < n; j++) {
				if(arr[j] >= dp[i]) {
					dp[i] = arr[j];
					cnt++;
				} 
			}
			System.out.println("arr[" + i + "] : " + dp[i]  + "  cnt : " + cnt);
			max = cnt > max ? cnt : max; // �ִ�
		}
		System.out.println(max);
	}
}
