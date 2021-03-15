import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [B3] ���� ���� ũ�ξ�Ƽ��  */

public class q9517 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bomb = Integer.parseInt(br.readLine()); // ��ź�� ����ִ� ��� (1~8)
		int n = Integer.parseInt(br.readLine()); // ������ ����
		StringTokenizer st; 
		int time = 0; // 3��30�� -> 210��
		
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int ansTime = Integer.parseInt(st.nextToken());
			char ans = st.nextToken().charAt(0);
			
			time += ansTime; // �ð�

			if(time >= 210) // Ÿ�Ӿƿ�!
				break;
			
			if(ans == 'T' && i < n-1) { // �Ѱ��� ������ ���� ��
				bomb++; // ���� ������� �ѱ��
				if(bomb == 9) bomb = 1;// ���� 8�� �Ѿ�� 1�� �ٲٱ�
			}
		}
		System.out.println(bomb);
	}
}
