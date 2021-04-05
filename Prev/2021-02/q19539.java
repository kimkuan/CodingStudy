import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [S1] �������  */

public class q19539 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n]; // 1~n����
		int sum = 0, sum2 = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i]; // ��ǥ ������ ��
			sum2 += arr[i]/2; // 2��ŭ �� �� �ִ� Ƚ���� �� = �� �ִ� Ƚ��
		}
		
		if(sum % 3 == 0) { 
			if(sum2 >= (sum/3)) 
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		else
			System.out.println("NO");
	}
}

/*
	[ ���� Ǯ�� ]
	
	- 2�� 1�� �ִ� Ƚ���� �����ϴ�
	- ��� ������ ���� 3�� ����� �Ǿ�� �Ѵ� (3 or (2+1))
	- sum / 3 => ��ǥ  ���� �޼��� ���� �ɸ��� �ϼ�
	- sum2 => n���� ������ ���� 2��ŭ �ο� �� �ִ� Ƚ�� 
	
*/