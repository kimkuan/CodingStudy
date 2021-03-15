import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class q1049 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		ArrayList<Integer> setPrice = new ArrayList<>();
		ArrayList<Integer> onePrice = new ArrayList<>();
		
		int setMin, oneMin; // �ּڰ�
		int n, m; // ������ ��Ÿ�� N, ��Ÿ�� �귣�� M
		int ans = 0;
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int set = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
		
			setPrice.add(set);
			setPrice.add(one*6);
			onePrice.add(one);
		}
		setMin = Collections.min(setPrice); // �ּڰ� ���ϱ�
		oneMin = Collections.min(onePrice);		
		
		int setCount = n / 6;
		int oneCount = n % 6;
				
		if(setMin < oneMin * 6) { // ��Ʈ������ �� ��¥�� 6�� ��°� ���� �� ��
			ans += setMin * setCount;		
			if(setMin < oneMin * oneCount)  // �������� ������ ��� �� ���� ��Ʈ�� �� �� ��
				ans += setMin;
			else
				ans += oneMin * oneCount;
		}
		else // ������ ��°� �� �θ� �� ������ ����
			ans += oneMin * n;
		
		System.out.print(ans);
	}
}

/*
	������ ��Ÿ�� N, ��Ÿ�� �귣�� M
	�귣�� ���� ��Ʈ ����(6��), ���� ����(1��)
	6�� �̻� ������ ��, ��Ʈ ���ݰ� ������ 6�� ���� �� 
	
	(������ �ڵ�)
	res[0] = ��Ʈ + ���� ����
	res[1] = ��Ʈ��
	res[2] = ������
	
	sort(res, res+3); �ؼ� �ּڰ� ���ϱ�
*/