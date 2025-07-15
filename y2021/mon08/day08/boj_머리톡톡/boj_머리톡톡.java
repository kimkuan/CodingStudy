package y2021.mon08.day08.boj_머리톡톡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_머리톡톡 {
	
	static int[] count = new int[1000001]; // �л����� ������ �ִ� ���ڵ� ���� ī��Ʈ
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] number = new int[N];
		
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(br.readLine());
			count[number[i]] += 1; // ������ ���� + 1
		}	
		
		for (int i = 0; i < N; i++) {
			int n = number[i];
			int answer = 0;
			int size =  (int) Math.sqrt(n);
			for (int j = 1; j <= Math.sqrt(n); j++) {
				if(n % j == 0) { // N�� j�� ����� �ƴ� ���� PASS
					answer += count[j];
					
					if(j*j < n) // �������� �ƴϸ� j�� ¦�� �̷�� ����� ���� ���� ex) 16�� ����� (1,16) (2, 8)
						answer += count[n/j];
				}
			}
			sb.append(answer-1).append("\n"); // �ڱ��ڽ��� ����
		}
		System.out.print(sb);
	}
}
