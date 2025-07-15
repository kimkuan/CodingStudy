package y2021.mon08.day29.prog_등굣길;

public class prog_등굣길 {
	
	static int m = 4; // ��
	static int n = 3; // ��
	static int[][] puddles = {{2, 4}, {3, 3}};

	public static void main(String[] args) {
		
		long[][] arr = new long[n+1][m+1]; // (1, 1)���� ����
		
		// ù��° '��'�� ���� 1�� �ʱ�ȭ 
		for (int i = 1; i <= m; i++) { 
			arr[1][i] = 1;
		}
		 // ù��° '��'�� ���� 1�� �ʱ�ȭ 
		for (int i = 1; i <= n; i++) {
			arr[i][1] = 1;
		}
		
		for (int i = 0; i < puddles.length; i++) {
			int x = puddles[i][0];
			int y = puddles[i][1];
			arr[x][y] = -1; // �� ������
		}
		
		
		for (int i = 2; i <= n; i++) {
			for(int j = 2; j <= m; j++) {
				// arr[i][j-1] & arr[i-1][j] �� ���� ����
				
				if(arr[i][j] == -1) continue; // ���� ��ġ�� �������̸� PASS
				if(arr[i][j-1] == -1 && arr[i-1][j] == -1) continue; // �Ǵ� ���Ʒ� ��� �������̸� PASS
                
				if(arr[i][j-1] == -1)
					arr[i][j] = arr[i-1][j];
				else if(arr[i-1][j] == -1)
					arr[i][j] = arr[i][j-1];
				else
					arr[i][j] = (arr[i][j-1] +arr[i-1][j]) % 1000000007;
			}
		}
		System.out.println(arr[n][m]);
	}
}
