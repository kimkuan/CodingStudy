import java.io.BufferedReader;
import java.io.InputStreamReader;

/* [B2] ��Ȧ��  */

public class q2810 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // �¼�����
		char[] seats = br.readLine().toCharArray();
		int ans = 0;
		
		for(int i = 0; i < n; i++) {
			if(seats[i] == 'L') // L�� ��
				i++; // 2ĭ �Ѿ��
			ans++;
		}
		ans = ans+1; // ������ �¼��� ������ ��Ȧ�� �߰� 
		
		if(n < ans) // ����� ���� �ִ� ��밡���� ��Ȧ�� �� ���� ������ ����� �� ���
			ans = n;
		
		System.out.println(ans);
	}
}
/*
	����ϴ� ���� ��Ȧ�� ���� �ƴ϶� ��Ȧ���� ����ϴ� ����� ��!!
*/