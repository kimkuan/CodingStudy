package y2021.mon09.day19.boj_퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_퇴사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] counseling = new int[N+2][2];
		int[] dp = new int[N+2]; // N+1�ϱ��� ���� ���� �� �� �ִ� ��
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			counseling[i][0] = time;
			counseling[i][1] = price;
		}
		
		// �����̰� N�ϱ��� ���� �� �ִ� �ִ� ���� ���ϱ�
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 1; i <= N+1; i++) {
			dp[i] = Math.max(dp[i], dp[i-1]); // ���� ����� dp[i] = 0 �̰ͺ��� �� ���� �̵��� ���� �� ������ 
			
			if(i + counseling[i][0] <= N+1)
				dp[i + counseling[i][0]] = Math.max(dp[i + counseling[i][0]], dp[i] + counseling[i][1]);
		}
		
//		for (int i = 1; i <= N+1; i++) {
//			System.out.println("[dp" + i + "] " + dp[i]);
//		}
		System.out.println(dp[N+1]);
	}

}
