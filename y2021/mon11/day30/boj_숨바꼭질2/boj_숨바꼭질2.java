package y2021.mon11.day30.boj_숨바꼭질2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_숨바꼭질2 {
	
	static int N, K;
	static int timeResult, countResult;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		findSister();
		
		System.out.println(timeResult);
		System.out.println(countResult);
	}

	
	private static void findSister() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int[] visited = new int[100001]; // �̹� �̵��� ��ġ�� ���� �ּ� �ð� ����
		int time = 0;
		
		// �������� ��ġ���� ����
		q.add(N);
		visited[N] = -1;

		// ���ۺ��� ���� ��ġ�� ���� ��
		if(N == K) {
			timeResult = 0;
			countResult = 1;
			return;
		}

		// �ƴ϶��, ���� ã��
		while(!q.isEmpty()) {
			int size = q.size();
			time++;
			
			for(int i = 0; i < size; i++) {
				int x = q.poll();
				int next;
								
				for(int j = 0; j < 3; j++) {
					next = nextStep(x, j);
				
					// ���� �湮�� ���� ���ų�, �ּ� �ð��ȿ� �湮�� ���
					if(next >= 0 && next <= 100000 && (visited[next] == 0 || visited[next] == time)) {
						q.add(next);
						visited[next] = time;
					}
					
					// ������ ã�Ҵٸ�
					if(next == K) {
						timeResult = time;
						countResult += 1;
					}
				}
			}

			// �̹� ������ ã�Ҵٸ�, ���̻� �õ����� X
			if(countResult > 0)
				break;
		}
	}
	
	static int nextStep(int x, int j) {
		if(j == 0)
			return x-1;
		else if(j == 1)
			return x+1;
		else
			return 2*x;
	}
}
