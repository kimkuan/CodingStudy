package y2021.mon10.day31.boj_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(find(start, end));
	}

	private static int find(int start, int end) {
		boolean[] visited = new boolean[100001];
		int size, time = 0;
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(start);
	
		while(!q.isEmpty()) {
			size = q.size();
			
			for(int i = 0; i < size; i++) {
				int current = q.poll();

				if(current == end)  // ������ ã�Ҵٸ�, ã�� �ð� ��ȯ
					return time;
				
				// X-1 �̵�
				if(current-1 >= 0 && !visited[current-1]) { 
					q.add(current-1);
					visited[current-1] = true;
				}
				
				// X+1 �̵�
				if(current+1 <= 100000 && !visited[current+1]) { 
					q.add(current+1);
					visited[current+1] = true;
				}
				
				// 2X �̵�
				if(current*2 <= 100000 && !visited[current*2]) {
					q.add(current*2);
					visited[current*2] = true;
				}
			}
			
			time++;
		}
		return time;
	}
}
