package y2021.mon11.day06.boj_소수인팰린드롬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_소수인팰린드롬 {
	
	static boolean[] isNotPrime = new boolean[100000001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		// �����佺�׳׽��� ü�� �̿��Ͽ� �Ҽ��� �̸� ���
		InitPrimeNumber();
		
		for(int i = a; i <= b; i++) {
			// �縰������� �Ǵ�
			if(!isPallendrom(i))
				continue;
			
			// �ش� ���ڰ� �Ҽ����� �Ǵ�
			if(isNotPrime[i]) 
				continue;
			
			sb.append(i + "\n");
		}
		sb.append(-1); // ������ �ٿ��� -1�� ���!
		System.out.print(sb.toString());
	}
	
	// �縰��� �Ǵ�
	private static boolean isPallendrom(int n) {
		String str = String.valueOf(n);
		int len = str.length(); // �ش� ������ �ڸ���
		
		// ¦�� �ڸ��� �����ε� �� ���� 11�� �ƴ� �� -> ¦�� �ڸ��� �����߿����� 11�� ����� �縰����� �����ϴ�
		if(len % 2 == 0 && n != 11)
			return false;
		
		int start = 0;
		int end = len - 1;
		while(start < end) {
			if(str.charAt(start) != str.charAt(end))
				return false;
		
			start++;
			end--;
		}
		return true;
	}

	// �Ҽ� �Ǵ�
	private static void InitPrimeNumber() {	
		double size = Math.sqrt(100000000);
	
		for (int i = 2; i <= size; i++) {
			// ���� �������� ���� ���̶�� -> ��, false��� (true�̸� �Ҽ��� �ƴ� ��)
			if(!isNotPrime[i]) {
				// i�� ����� �ش��ϴ� ��� ������ true�� ��ȯ
				for (int j = i+i; j <= 100000000; j += i) {
					isNotPrime[j] = true;
				}
			}	
		}
	}
}
