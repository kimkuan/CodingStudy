import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11053 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n]; // 탐색할 때마다 증가하는 값
		int max = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		for(int i = 0; i < n; i++) { // 최대 개수를 위해서는 크다고 다 뽑으면 안됨
			int cnt = 0;
			for(int j = i; j < n; j++) {
				if(arr[j] >= dp[i]) {
					dp[i] = arr[j];
					cnt++;
				} 
			}
			System.out.println("arr[" + i + "] : " + dp[i]  + "  cnt : " + cnt);
			max = cnt > max ? cnt : max; // 최댓값
		}
		System.out.println(max);
	}
}
