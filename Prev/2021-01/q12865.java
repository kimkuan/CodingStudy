import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q12865 {

	static int[][] dp;
	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물건의 개수
		int K = Integer.parseInt(st.nextToken()); // 가방의 무게	
		
		dp = new int[N+1][K+1]; // (default : 0)
	    arr = new int[N+1][2];

		// 물건의 개수
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[i][0] = w;
			arr[i][1] = v;
		}
		
		// 베낭무게가 j일 때 i번째 물건을 드는 최대 가치 
		for(int i = 1; i <= N; i++) { // i = 1일 때, w = 6 , v = 13
			int w = arr[i][0];
			int v = arr[i][1];
			
			for(int j = 1; j <= K; j++) { // 배낭이 담을 수 잇는 무게
				if(j < w) { // 해당 물건이 배낭이 담을 수 있는 무게보다 무거우면
					dp[i][j] = dp[i-1][j]; // 더 담을 수 없음(= 이전 최대값 그대로)
				}
				else { // 배낭에 담을 수 있으면
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w] + v); // 최대값 비교해서 담을지 말지 선택
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}

/*
 * 현재 배낭에 i번째 물건을 담을 수 있는 경우
 * 1) 담는다 --> dp[i][j] = dp[i][j - i번째 물건의 무게] + 해당차례 물건 가치
 * 2) 담지 않는다 --> dp[i][j] = dp[i-1][j] (저번 물건을 담았을 때의 배낭 무게의 최대 가치)
 * => 둘 중 높은 것이 우리가 원하는 배낭이다.
 * 
 */
