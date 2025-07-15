package y2021.mon09.day11.prog_6주차;

import java.util.Arrays;
import java.util.Comparator;

public class prog_6주차 {

	static int[] weights = {50,82,75,120};
	static String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};
	
	public static void main(String[] args) {
		
		int N = weights.length;
		double[] winPercent = new double[N]; // �ٸ� ������ �پ �̱� �·�
		int[] winMoreWeight = new int[N]; // �ڽź��� ���ſ� ����� �پ �̱� Ƚ��
		
		for (int i = 0; i < N; i++) {
			int count = 0; // �ٸ� ������ ���� Ƚ��
			int win = 0; // �ٸ� ������ �پ �̱� Ƚ��
			int winWithMore = 0; // �ڽź��� ���ſ� ������ �̱� Ƚ��
			
			for (int j = 0; j < N; j++) {
				if(head2head[i].charAt(j) == 'N') 
					continue;
				
				if(head2head[i].charAt(j) == 'W') {
					win++;
					winWithMore += weights[i] < weights[j] ? 1 : 0; 
				}
				count++;
			}
			winPercent[i] = count == 0 ? 0 : (double)win/count * 100;
			winMoreWeight[i] = winWithMore;
		}
		
		Integer[] player = new Integer[N];
		for (int i = 0; i < N; i++) { // 1�� ~ N�� ������ ����
			player[i] = i;
		}
		
		Arrays.sort(player, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int cmp = Double.compare(winPercent[o2], winPercent[o1]);
				
				if(cmp == 0) 
					cmp = Integer.compare(winMoreWeight[o2], winMoreWeight[o1]);
				if(cmp == 0)
					cmp = Integer.compare(weights[o2], weights[o1]);
				if(cmp == 0)
					cmp = Integer.compare(o1, o2);
					
				return cmp;
			}
		});
		
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) { // 1�� ~ N�� ������ ����
			answer[i] = player[i]+1;
		}
	}
}

// ��ü �·��� ���� ������ ��ȣ�� �������� ���ϴ�. ���� �ٸ� ������ �پ ���� ���� ������ �·��� 0%�� ����մϴ�.
// �·��� ������ ������ ��ȣ�� �߿����� �ڽź��� �����԰� ���ſ� ������ �̱� Ƚ���� ���� ������ ��ȣ�� �������� ���ϴ�.
// �ڽź��� ���ſ� ������ �̱� Ƚ������ ������ ������ ��ȣ�� �߿����� �ڱ� �����԰� ���ſ� ������ ��ȣ�� �������� ���ϴ�.
// �ڱ� �����Ա��� ������ ������ ��ȣ�� �߿����� ���� ��ȣ�� �������� ���ϴ�.
