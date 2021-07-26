package mon07.day26.boj_����ѹ賶;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_����ѹ賶 {
	
	static int N, K;
	static int[][] dp;
	static Integer[][] things;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		things = new Integer[N+1][2];
		
		things[0][0] = 0;
		things[0][1] = 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = Integer.parseInt(st.nextToken()); // w ����
			things[i][1] = Integer.parseInt(st.nextToken()); // v ��ġ
		}

		Arrays.sort(things, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		dp = new int[K+1][N+1];
		for(int k = 1; k <= K; k++) { // ���濡 ���� �� �ִ� �ִ� ���԰� 0�� �� ���� K�� �� ���� 
			for(int j = 1; j <= N; j++) {
				// �ٷ� ���� ���� �״�� ���ų�, ���� ����� ��(������ ���Ը�ŭ ���� �� �ִ� + ���� ���Կ��� �ִ�)�� ���ų�
				if(k-things[j][0] >= 0) {
					dp[k][j] = Math.max(dp[k][j-1], dp[k-things[j][0]][j-1] + things[j][1]);
				}else {
					dp[k][j] = dp[k][j-1];
				}
			}		
		}
		System.out.println(dp[K][N]);
	}
}
