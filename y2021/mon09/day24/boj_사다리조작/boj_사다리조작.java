package y2021.mon09.day24.boj_사다리조작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_사다리조작 {

	static int N, M, H;
	static int result = Integer.MAX_VALUE;
	static int[][] ladder;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ladder = new int[N+1][H+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
		
			ladder[b][a] = b+1;
			ladder[b+1][a] = b;
		}
		gamestart(0, 1, 1);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	// addCount : ������� �߰��� ���μ��� ����
	// row : ���� �������� ��ġ
	// col : ���� �������� ��ġ
	private static void gamestart(int addCount, int row, int col) {
		// ������ 3���� ū ���̸� �Ұ��� �ϴٰ� �Ǵ��Ѵ�.
		if(addCount > 3) {
			return ;
		}
				
		// ��� i��° ���μ��� ����� i���� �������� üũ
		if(success()) {
			result = Math.min(addCount, result);
			return ;
		}
		
		// i��° ������, j��° ������
		for(int i = row; i <= H; i++) {
			for(int j = 1; j < N; j++) {

				if(ladder[j][i] > 0 || ladder[j+1][i] > 0) // �̹� ��ٸ��� �����ϸ� PASS
					continue;
				
				ladder[j][i] = j+1;
				ladder[j+1][i] = j;
				gamestart(addCount+1, i, j+2);
				ladder[j][i] = 0;
				ladder[j+1][i] = 0;
				
			}
		}
	}
	
	// i��° ���μ��� ����� i���� �������� üũ�ϴ� �޼ҵ�
	private static boolean success() {
		
		for(int i = 1; i <= N; i++) {
			int currentCol = i; // ���� ������ ��ȣ
			int currentRow = 0; // ���� ������ ��ȣ
			
			while(true) {
				boolean noMoreLadder = true;
				
				// ���� �����ٹ�ȣ���� ū �� �߿��� ���� ���� ���� �̱�
				for(int j = currentRow; j <= H; j++) {
					if(ladder[currentCol][j] == 0) // ��ٸ��� ������ PASS 
						continue;
					
					// ��ٸ� �̵�
					currentRow = j+1;
					currentCol = ladder[currentCol][j]; 
					noMoreLadder = false;
					break;
				}
				
				// �� �̻� �� �� �ִ� ��ٸ��� ������ i������ �����ؼ� i������ �������� üũ
				if(noMoreLadder) {
					if(currentCol != i)
						return false;
					else
						break;
				}
			}
		}
		return true;
	}
	
//	private static void print() {
//		for(int i = 0; i <= N; i++) {
//			for (int j = 0; j <= H; j++) {
//				System.out.print(ladder[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}

// ���μ��� ���μ��� �������� ���� �� ����.
// ������ 3���� ū ���̸� -1�� ����Ѵ�. ���� �Ұ����� ��쿡�� -1�� ����Ѵ�.
