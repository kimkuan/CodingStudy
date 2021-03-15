import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [S2] â�� �ٰ��� - 2304�� */

class Pillar{
	int x;
	int h;

	public Pillar(int x, int h) {
		this.x = x;
		this.h = h;
	}
}

public class q2304 {
	
	static int getMax(Queue<Pillar> q) {
		int max = 0;
		
		for(int i = 0; i < q.size(); i++) {
			Pillar p = q.poll();
			max = p.h > max ? p.h : max; 
			q.add(p);
		}
		return max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Pillar> list = new ArrayList<>(); 
		Queue<Pillar> q = new LinkedList<>();
		
		int max = 0; // max�� �������� ����
		int area = 0; // ���� 	
		boolean flag = false; // ���� ū ���� ���Դ��� Ȯ��
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			list.add(new Pillar(key, value));
			max = Math.max(max, value); // �ִ� ����
		}
		
		Collections.sort(list, new Comparator<Pillar>() {
			@Override
			public int compare(Pillar o1, Pillar o2) {
				return o1.x - o2.x; // ��������
			}	
		});
		
		for(Pillar p : list) 
			q.add(p); // ť�� �ֱ�	
		
		int prev_x = 0; // ���� ��ġ
		int prev_h = 0; // ���� ����
		
		while(!q.isEmpty()) {

			if(flag) { // ������
				max = getMax(q); // ���� ť�� �ִ� �� �� �ִ�		
				Pillar p = q.poll();
				
				if(p.h == max) {
					p.x++; // ���̸� ���� �� �ش� ���簢������ ����.

					area += (p.x - prev_x) * p.h; // ���� ���ϱ�
					prev_x = p.x;
					prev_h = p.h;
				}
			}
			else { // ������
				Pillar p = q.poll();

				if(p.h > prev_h) {
					area += (p.x - prev_x) * prev_h; // ���̱��ϱ�
					prev_x = p.x;
					prev_h = p.h;
					
					if(p.h == max) {
						flag = true;
						area += p.h;
						prev_x++; // max ���ĺ��� ���� �׷����� ���������� ���
					}
				}
			}
		}
		System.out.println(area);
		
	}
}
