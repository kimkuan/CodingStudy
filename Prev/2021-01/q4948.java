import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* [S2] ����Ʈ�� ���� - 4948�� */

public class q4948 {
	
	// �Ҽ����� üũ
	static boolean checkFactor(int n) {
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			if(n == 0)
				break;
			
			for(int i = n+1; i <= 2*n; i++) {
				if(checkFactor(i))
					cnt++;
			}
			System.out.println(cnt);
		}
	}
	/*
	 * �����佺�׳׽��� ü
	 * : �ٽ� �����ϱ�!!
	 */
}
