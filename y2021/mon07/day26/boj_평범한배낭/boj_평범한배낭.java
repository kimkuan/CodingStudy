package y2021.mon07.day26.boj_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_평범한배낭 {
	
	static int N, K;
	static int[][] things;
	static int[] dp; // ������ �迭�� ����ϸ�, ������ ����� ���� �״�� ���� (�ִ� ���԰� k�� ���濡�� ���� ū ��ġ�� ���Ե�)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		things = new int[N+1][2];
		dp = new int[K+1];
		
		things[0][0] = 0;
		things[0][1] = 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = Integer.parseInt(st.nextToken()); // w ����
			things[i][1] = Integer.parseInt(st.nextToken()); // v ��ġ
		}

		for (int i = 1; i <= N; i++) {
			for(int j = K; j-things[i][0] >= 0; j--) { // K�������� ���� ������ ���� �� �ִ� ���Ա����� Ž��
				dp[j] = Math.max(dp[j], dp[j-things[i][0]] + things[i][1]);
			}
		}
		System.out.println(dp[K]);
	}
}
