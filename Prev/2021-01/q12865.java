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
		int N = Integer.parseInt(st.nextToken()); // ������ ����
		int K = Integer.parseInt(st.nextToken()); // ������ ����	
		
		dp = new int[N+1][K+1]; // (default : 0)
	    arr = new int[N+1][2];

		// ������ ����
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[i][0] = w;
			arr[i][1] = v;
		}
		
		// �������԰� j�� �� i��° ������ ��� �ִ� ��ġ 
		for(int i = 1; i <= N; i++) { // i = 1�� ��, w = 6 , v = 13
			int w = arr[i][0];
			int v = arr[i][1];
			
			for(int j = 1; j <= K; j++) { // �賶�� ���� �� �մ� ����
				if(j < w) { // �ش� ������ �賶�� ���� �� �ִ� ���Ժ��� ���ſ��
					dp[i][j] = dp[i-1][j]; // �� ���� �� ����(= ���� �ִ밪 �״��)
				}
				else { // �賶�� ���� �� ������
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w] + v); // �ִ밪 ���ؼ� ������ ���� ����
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}

/*
 * ���� �賶�� i��° ������ ���� �� �ִ� ���
 * 1) ��´� --> dp[i][j] = dp[i][j - i��° ������ ����] + �ش����� ���� ��ġ
 * 2) ���� �ʴ´� --> dp[i][j] = dp[i-1][j] (���� ������ ����� ���� �賶 ������ �ִ� ��ġ)
 * => �� �� ���� ���� �츮�� ���ϴ� �賶�̴�.
 * 
 */
